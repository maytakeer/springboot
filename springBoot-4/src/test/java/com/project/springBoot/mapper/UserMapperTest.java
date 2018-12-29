package com.project.springBoot.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.springBoot.entity.UserEntity;
import com.project.springBoot.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsert() throws Exception{
		userMapper.insert(new UserEntity("aa","a123456",UserSexEnum.MAN));
		userMapper.insert(new UserEntity("bb","b123456",UserSexEnum.WOMAN));
		userMapper.insert(new UserEntity("cc","c123456",UserSexEnum.WOMAN));
		
		System.out.println(userMapper.getAll().size());
	}
	
	@Test
	public void testQuery() throws Exception{
		List<UserEntity> users = userMapper.getAll();
		if (users == null || users.size() == 0) {
			System.out.println("is null");
		}else {
			System.out.println(users.size());
		}
	}
	
	@Test
	public void testUpdate() throws Exception{
		UserEntity user = userMapper.getOne(3L);
		System.out.println(user.toString());
		user.setNickName("zq");
		userMapper.update(user);
		System.out.println(userMapper.getOne(3L).getNickName());
		
	}
}
