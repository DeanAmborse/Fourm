package com.Esport.work.service;


import com.Esport.work.entity.UserState;
import com.Esport.work.entity.Users;

public interface UserService {
	void register(Users users);
	Users login(String username,String password);
	void insert(UserState uState);
	UserState findByToken(String token);
}
