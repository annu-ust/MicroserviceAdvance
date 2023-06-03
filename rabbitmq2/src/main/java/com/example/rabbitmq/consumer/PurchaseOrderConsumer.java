package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
//consumer can be any type of class may be java class /restapi etc
	
     @RabbitListener(queues="ust_queue")
	public void consumeMessageFromQueue(OrderStatus orderstatus) {
		System.out.println("Message received from queue : "+orderstatus);
	}
}
