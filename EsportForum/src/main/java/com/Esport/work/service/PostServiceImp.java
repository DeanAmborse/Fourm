package com.Esport.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Esport.work.dao.PostDao;
import com.Esport.work.entity.Post;

@Service
@Transactional
public class PostServiceImp implements PostService{
	
	@Autowired
	PostDao postDao;
	@Override
	public void Save(Post post) {
		// TODO Auto-generated method stub
		postDao.Save(post);
	}

}
