package com.Esport.work.service;

import java.util.List;

import com.Esport.work.entity.PageDTO;
import com.Esport.work.entity.Post;

public interface PostService {
	void save(Post post);
	PageDTO list(Integer page,Integer size);
}
