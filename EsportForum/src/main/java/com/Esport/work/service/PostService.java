package com.Esport.work.service;

import java.util.List;

import com.Esport.work.entity.Post;
import com.Esport.work.entity.PostDTO;

public interface PostService {
	void save(Post post);
	List<PostDTO> list();
}
