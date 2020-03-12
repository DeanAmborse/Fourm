package com.Esport.work.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Esport.work.entity.Post;

public interface PostDao {
	void save(Post post);
	List<Post> list(@Param(value = "offset")Integer offset,@Param(value = "size")Integer size);
	Integer count();
}
