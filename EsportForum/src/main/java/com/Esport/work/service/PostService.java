package com.Esport.work.service;

import com.Esport.work.DTO.PageDTO;
import com.Esport.work.DTO.PostDTO;
import com.Esport.work.entity.Post;

public interface PostService {
	PageDTO list(Integer page,Integer size);
	PageDTO list1(String creatorID, Integer page, Integer size);
	PostDTO getById(Integer id);
	Post getbyId(Integer id);
	int upComment(Integer id);
	void saveORupdate(Post post);
	void UpView(Post post);
}
