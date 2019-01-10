package com.project.springBoot.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender1 {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(int i){
		String context = "spring boot neo queue"+" ***** "+i;
		System.out.println("Sender1: "+context);
		this.amqpTemplate.convertAndSend("neo",context);
	}
}
