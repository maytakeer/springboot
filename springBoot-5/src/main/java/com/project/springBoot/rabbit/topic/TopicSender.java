package com.project.springBoot.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(){
		String context = "this id message all";
		System.out.println("Sender : "+context);
		this.amqpTemplate.convertAndSend("topicExchange","topic.1",context);
	}
	
	public void send1(){
		String context = "this id message 1";
		System.out.println("Sender : "+context);
		this.amqpTemplate.convertAndSend("topicExchange","topic.message",context);
	}
	
	public void send2(){
		String context = "this id message 2";
		System.out.println("Sender : "+context);
		this.amqpTemplate.convertAndSend("topicExchange","topic.messages",context);
	}
}
