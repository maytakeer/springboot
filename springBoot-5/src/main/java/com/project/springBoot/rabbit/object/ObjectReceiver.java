package com.project.springBoot.rabbit.object;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.project.springBoot.entity.User;

@Component
public class ObjectReceiver {
	
	//@RabbitListener 注解是方法级别的，不能用在class上
	@RabbitListener(queues = "object")
	@RabbitHandler
	public void process(User user) throws Exception{
		System.out.println("Receiver object : " + user);
	}
	
}
