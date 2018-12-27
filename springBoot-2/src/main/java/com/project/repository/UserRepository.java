package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String name);
	
	User findByUserNameOrEmail(String username,String email);
	
}
