package com.project.springBoot.service;

import com.project.springBoot.entity.UserInfo;

public interface UserInfoService {
	
	UserInfo findByUsername(String username);
	
}
