package com.project.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.springBoot.rabbit.many.NeoSender1;
import com.project.springBoot.rabbit.many.NeoSender2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	
	@Autowired 
	private NeoSender1 neoSender1;
	
	@Autowired
	private NeoSender2 neoSender2;
	
	@Test
	public void oneToMany() throws Exception{
		for (int i = 0; i < 100; i++) {
			neoSender1.send(i);
		}
	}
}
