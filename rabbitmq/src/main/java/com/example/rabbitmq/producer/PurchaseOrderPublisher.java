package com.example.rabbitmq.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.config.MessagingConfig;
import com.example.rabbitmq.model.OrderStatus;
import com.example.rabbitmq.model.PurchaseOrder;

@RestController
@RequestMapping("/order")
public class PurchaseOrderPublisher {
//publisher(producer) has a dependency on template
//the connection is done by template
	@Autowired
	RabbitTemplate template;
	
	@PostMapping("/bookorder/{customerName}")
	public String bookOrder(@RequestBody PurchaseOrder order,@PathVariable String customerName) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderStatus orderstatus=new OrderStatus(order,"ACCEPTED","order placed successfully by"+customerName);
		template.convertAndSend(MessagingConfig.Exchange, MessagingConfig.Routing_Key, orderstatus);
		return "Success";
	}
}
