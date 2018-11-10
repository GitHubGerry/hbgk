package com.gywsystem3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gywsystem3.mapper.UserMapper;
import com.gywsystem3.po.User;
import com.gywsystem3.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper user;
	@Override
	public User login(String userid,String password){
		return user.login(userid, password);
	}
}
