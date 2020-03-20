package com.Esport.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Esport.work.entity.Comment;

public interface CommentDao {
	void insert(Comment comment);
	Comment findbyID(@Param(value = "id") Integer id);
	int commentCount(@Param(value = "parentId") Integer parentId);
	List<Comment> list(@Param(value ="parentId") Integer parentId); 
}
