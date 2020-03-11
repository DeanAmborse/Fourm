package com.Esport.work.dao;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import com.Esport.work.entity.UserState;
import com.Esport.work.entity.Users;

public interface UserDao {
	void regist(Users users);
	void insert(UserState uState);
	UserState findByToken(String token);
	Users findById(String id);
	Users login(@Param("username") String username,@Param("password")String password);
	Users findUserByName(String username);
	Users UpdateUsername(Users users);
	Users UpdateUserpwd(User users);
}
