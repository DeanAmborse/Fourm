package com.Esport.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Esport.work.DTO.CommentListDTO;
import com.Esport.work.DTO.CommentgetDTO;
import com.Esport.work.Enum.CommentTypeEnum;
import com.Esport.work.dao.CommentDao;
import com.Esport.work.dao.PostDao;
import com.Esport.work.dao.UserDao;
import com.Esport.work.entity.Comment;
import com.Esport.work.entity.Post;
import com.Esport.work.entity.Users;
import com.Esport.work.exception.CustomizeErrorCode;
import com.Esport.work.exception.CustomizeException;

@Service
@Transactional
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	@Override
	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		if(comment.getParentId() == null ||comment.getParentId() ==0) {
			throw new CustomizeException(CustomizeErrorCode.TARGET_NOT_FOUND);	
		}
		if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
			throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
		}
		if(comment.getType() == CommentTypeEnum.COMMENT.getType()) {
			Comment comment2 = commentDao.findbyID(comment.getParentId());
			if(comment2 == null) {
				throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
			}
			commentDao.insert(comment);	
		}else {
			Post post = postDao.getById(comment.getParentId());
			if(post == null) {
				throw new CustomizeException(CustomizeErrorCode.POST_NOT_FOUND);
			}
			commentDao.insert(comment);
		}
			
	}
	@Override
	public CommentListDTO listByPid(Integer pid) {
		// TODO Auto-generated method stub
		CommentListDTO cListDTO = new CommentListDTO();
		List<Comment> comment = commentDao.list(pid);
		List<CommentgetDTO> comments = new ArrayList<>();
		for (Comment comment2 : comment) {
			Users u = userDao.findById(comment2.getCommentor());
			CommentgetDTO cDto = new CommentgetDTO();
			BeanUtils.copyProperties(comment2, cDto);
			cDto.setUsers(u);
			comments.add(cDto);
		}
		cListDTO.setComments(comments);
		return cListDTO;
	}
}
