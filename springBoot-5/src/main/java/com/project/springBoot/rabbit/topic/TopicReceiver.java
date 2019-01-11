package com.project.springBoot.rabbit.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {
	
	@RabbitListener(queues = "topic.message")
	@RabbitHandler
	public void process(String message){
		System.out.println("Topic Receiver1 : " + message);
	}
}
