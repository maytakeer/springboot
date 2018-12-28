package com.project.springBoot.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.project.springBoot.entity.UserEntity;
import com.project.springBoot.enums.UserSexEnum;

public interface UserMapper {
	
	@Select("select * from users")
	@Results({
		@Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
		@Result(property = "nickName",column = "nick_name")
	})
	List<UserEntity> getAll();
	
	@Select("select * from users where id = #{id}")
	@Results({
		@Result(property = "userSex",column = "user_sex",javaType = UserSexEnum.class),
		@Result(property = "nickName",column = "nick_name")
	})
	UserEntity getOne(Long id);
	
	@Insert("insert into users(userName,passWord,user_sex) values(#{userName},#{passWord},#{userSex})")
	void insert(UserEntity user);
	
	@Update("update users set userName=#{userName},nick_name=#{nickName} where id=#{id}")
	void update(UserEntity user);
	
	@Delete("delect from users where id=#{id}")
	void delete(Long id);
	
}
