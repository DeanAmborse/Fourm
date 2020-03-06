package com.Esport.work.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Esport.work.dao.PostDao;
import com.Esport.work.entity.Post;

public class PostServiceImp implements PostService{
	
	@Autowired
	PostDao postDao;
	@Override
	public void Save(Post post) {
		// TODO Auto-generated method stub
		postDao.Save(post);
	}

}
