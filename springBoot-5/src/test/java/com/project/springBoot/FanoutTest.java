package com.project.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.springBoot.rabbit.fanout.FanoutSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutTest {
	
	@Autowired
	private FanoutSender fanoutSender;
	
	@Test
	public void test(){
		fanoutSender.send("zq");
	}
}
