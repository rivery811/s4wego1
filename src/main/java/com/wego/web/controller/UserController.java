package com.wego.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.wego.web.domains.UserDTO;
import com.wego.web.serviceimpl.UserServiceImpl;
@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired UserDTO user;

	@Autowired Map<String, Object>map;
	@Autowired UserServiceImpl userServiceImpl;


	@PostMapping("/join")
	public @ResponseBody Map<?,?> finduserinfobyId(@RequestBody  UserDTO param) {
		HashMap<String, String> map = new HashMap<>();
		map.put("uid", param.getUid());
		map.put("pwd", param.getPwd());
		map.put("uname", param.getUname());
/*		user.setUid(param.getUid());
		user.setPwd(param.getPwd());
		user.setUname(param.getUname());*/
		//logger.info("ajax가 보낸 아이디와 비번{}",user.getUid()+","+user.getPwd());
		logger.info("ajax가 보낸 아이디와 비번{},",map.get("uid")+","+map.get("pwd")+","+map.get("uname"));
		userServiceImpl.join(param);
		return map;
	}
	@PostMapping("/login")
	public @ResponseBody UserDTO finduserById(@RequestBody UserDTO param){
		user.setUid(param.getUid());
		user.setPwd(param.getPwd());
		user.setUname(param.getUname());
		logger.info("로긴ajax가 보낸 사용자 정보{}",user.toString());
		return userServiceImpl.selectUserByID(param);
	}
	
}
