package com.Esport.work.dao;


import java.util.List;

import com.Esport.work.entity.Post;

public interface PostDao {
	void save(Post post);
	List<Post> list();
}
