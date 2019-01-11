package com.project.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.springBoot.rabbit.topic.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
	
	@Autowired
	private TopicSender topicSender;
	
	@Test
	public void test(){
		topicSender.send();
	}
	
	@Test
	public void test1(){
		topicSender.send1();
	}
	
	@Test
	public void test2(){
		topicSender.send2();
	}
	
	

}
