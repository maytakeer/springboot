package com.project.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springBoot.entity.UserEntity;
import com.project.springBoot.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("getUsers")
	public List<UserEntity> getUsers(){
		List<UserEntity> users = userMapper.getAll();
		return users;
	}
}
