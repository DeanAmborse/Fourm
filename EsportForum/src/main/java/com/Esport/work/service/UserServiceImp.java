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
		// TODO Auto-generated method stub
		userdao.regist(users);
	}

	@Override
	public Users login(String username,String password) {
		// TODO Auto-generated method stub
		return userdao.login(username,password);
	}

	@Override
	public void insert(UserState uState) {
		// TODO Auto-generated method stub
		userdao.insert(uState);
	}

	@Override
	public UserState findByToken(String token) {
		// TODO Auto-generated method stub
		return userdao.findByToken(token);
	}

}
