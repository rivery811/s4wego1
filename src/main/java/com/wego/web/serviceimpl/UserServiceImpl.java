package com.wego.web.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wego.web.domains.UserDTO;
import com.wego.web.mappers.UserMapper;
import com.wego.web.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDTO user;
	@Autowired UserMapper userMapper;
	public UserDTO selectUserByID(UserDTO param) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(param);
	}
	public void join(UserDTO param) {
		userMapper.insertUser(param);
	}

}
