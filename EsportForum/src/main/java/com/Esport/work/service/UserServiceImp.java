package com.Esport.work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Esport.work.dao.UserDao;
import com.Esport.work.entity.UserState;
import com.Esport.work.entity.Users;

@Service
@Transactional
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userdao;

	@Override
	public void register(Users users) {
		userdao.regist(users);
	}

	@Override
	public Users login(String username,String password) {
		return userdao.login(username,password);
	}

	@Override
	public void insert(UserState uState) {
		userdao.insert(uState);
	}

	@Override
	public UserState findByToken(String token) {
		return userdao.findByToken(token);
	}

}
