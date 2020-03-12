package com.Esport.work.service;

import com.Esport.work.entity.PageDTO;
import com.Esport.work.entity.Post;

public interface PostService {
	void save(Post post);
	PageDTO list(Integer page,Integer size);
	PageDTO list1(String creatorID, Integer page, Integer size);
}
