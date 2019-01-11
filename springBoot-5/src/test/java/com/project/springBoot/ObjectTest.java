package com.project.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.springBoot.entity.User;
import com.project.springBoot.rabbit.object.ObjectSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {
	
	@Autowired
	private ObjectSender objectSender;
	
	@Test
	public void sendObject() throws Exception{
		User user = new User();
		user.setName("zq");
		user.setPass("123456");
		objectSender.send(user);
	}
}
