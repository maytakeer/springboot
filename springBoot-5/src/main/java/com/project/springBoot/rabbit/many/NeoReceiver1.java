package com.project.springBoot.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="neo")
public class NeoReceiver1 {
	
	@RabbitHandler
	public void process(String neo){
		System.out.println("receive1 : "+neo);
	}
}