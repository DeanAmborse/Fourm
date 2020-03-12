package com.Esport.work.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Esport.work.dao.PostDao;
import com.Esport.work.dao.UserDao;
import com.Esport.work.entity.PageDTO;
import com.Esport.work.entity.Post;
import com.Esport.work.entity.PostDTO;
import com.Esport.work.entity.Users;

@Service
@Transactional
public class PostServiceImp implements PostService{
	@Autowired
	private PostDao postDao;
	@Autowired
	private UserDao userDao;
	@Override
	public void save(Post post) {
		// TODO Auto-generated method stub
		postDao.save(post);
	}
	@Override
	public PageDTO list(Integer page,Integer size) {
		// TODO Auto-generated method stub
		Integer totalCount = postDao.count();
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPageDTO(totalCount,page,size);
		if(page < 1) {
			page = 1;
		}
		if(page > pageDTO.getTotalPage()) {
			page = pageDTO.getTotalPage();
		}
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

}
