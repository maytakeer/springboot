package com.project.springBoot.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiverB {
	
	@RabbitListener(queues="fanout.B")
	@RabbitHandler
	public void process(String message){
		System.out.println("fanout Receiver B : " + message);
	}
	
}
