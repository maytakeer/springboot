package com.project.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springBoot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String name);
	
	User findByUserNameOrEmail(String username,String email);
	
}
