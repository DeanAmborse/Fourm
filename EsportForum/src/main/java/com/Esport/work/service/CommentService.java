package com.Esport.work.service;

import com.Esport.work.DTO.CommentListDTO;
import com.Esport.work.entity.Comment;

public interface CommentService {
	void insert(Comment comment);
	CommentListDTO listByPid(Integer pid);
}
