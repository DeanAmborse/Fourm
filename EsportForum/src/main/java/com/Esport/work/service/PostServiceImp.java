package com.Esport.work.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Esport.work.DTO.PageDTO;
import com.Esport.work.DTO.PostDTO;
import com.Esport.work.dao.CommentDao;
import com.Esport.work.dao.PostDao;
import com.Esport.work.dao.UserDao;
import com.Esport.work.entity.Post;
import com.Esport.work.entity.Users;
import com.Esport.work.exception.CustomizeErrorCode;
import com.Esport.work.exception.CustomizeException;

@Service
@Transactional
public class PostServiceImp implements PostService{
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommentDao commentDao;
	@Override
	public PageDTO list(Integer page,Integer size) {
		// TODO Auto-generated method stub
		Integer totalPage ;
		Integer totalCount = postDao.count();
		if(totalCount % size == 0) {
			totalPage = totalCount / size;
		}else {
			totalPage = totalCount / size + 1;
		}
		if(page < 1) {
			page = 1;
		}
		if(page > totalPage) {
			page = totalPage;
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageDTO(totalPage,page);
		Integer offset = size * (page-1);
		List<Post> list = postDao.list(offset,size);
		List<PostDTO> list2 = new ArrayList<>();
		for (Post post : list) {
			Users user = userDao.findById(post.getCreatorID());
			PostDTO pDto = new PostDTO();
			BeanUtils.copyProperties(post, pDto);
			pDto.setUsers(user);
			list2.add(pDto);
		}
		pageDTO.setPosts(list2);
		
		return pageDTO;
	}
	@Override
	public PageDTO list1(String creatorID, Integer page, Integer size) {
		// TODO Auto-generated method stub
		Integer totalPage;
		Integer totalCount = postDao.countbyUser(creatorID);
		if(totalCount !=null) {
			if(totalCount % size == 0) {
				totalPage = totalCount / size;
			}else {
				totalPage = totalCount / size + 1;
			}
			PageDTO pageDTO = new PageDTO();
			if(page < 1) {
				page = 1;
			}
			if(page > totalPage) {
				page = totalPage;
			}
			pageDTO.setPageDTO(totalPage,page);
			Integer offset = size * (page-1);
			List<Post> list = postDao.list1(creatorID,offset,size);
			List<PostDTO> list2 = new ArrayList<>();
			for (Post post : list) {
				Users user = userDao.findById(post.getCreatorID());
				PostDTO pDto = new PostDTO();
				BeanUtils.copyProperties(post, pDto);
				pDto.setUsers(user);
				list2.add(pDto);
			}
			pageDTO.setPosts(list2);
			return pageDTO;
		}else {
			return null;
		}
	}
	@Override
	public PostDTO getById(Integer pid) {
		// TODO Auto-generated method stub
		Post post = postDao.getById(pid);
		if(post == null) {
			throw new CustomizeException(CustomizeErrorCode.POST_NOT_FOUND);
		}
		PostDTO postDTO = new PostDTO();
		BeanUtils.copyProperties(post, postDTO);
		Users users = userDao.findById(post.getCreatorID());
		postDTO.setUsers(users);
		return postDTO;
	}
	@Override
	public void saveORupdate(Post post) {
		// TODO Auto-generated method stub
		if(post.getPid() == null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			post.setPsendtime(df.format(new Date()));
			post.setUpdatetime(post.getPsendtime());
			postDao.save(post);
		}else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			post.setUpdatetime(df.format(new Date()));
			postDao.update(post);
		}
	}
	@Override
	public void UpView(Post post) {
		postDao.updateView(post);
	}
	@Override
	public Post getbyId(Integer id) {
		// TODO Auto-generated method stub
		Post post = postDao.getById(id);
		if(post == null) {
			throw new CustomizeException(CustomizeErrorCode.POST_NOT_FOUND);
		}
		return post;
	}
	@Override
	public int upComment(Integer id) {
		// TODO Auto-generated method stub
		return commentDao.commentCount(id);
	}

}
