package com.Esport.work.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Esport.work.entity.Post;

public interface PostDao {
	void save(Post post);
	List<Post> list(@Param(value = "offset")Integer offset,@Param(value = "size")Integer size);
	Integer count();
	List<Post> list1(@Param(value = "creatorID")String creatorID,@Param(value = "offset")Integer offset,@Param(value = "size")Integer size);
	Integer countbyUser(@Param(value = "creatorID") String creatorID);
	Post getById(@Param("pid") Integer pid);
	void update(Post post);
	void updateView(Post post);
	void updateComment(Post post);
}
