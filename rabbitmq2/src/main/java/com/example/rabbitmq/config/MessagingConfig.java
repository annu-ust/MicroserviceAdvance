package com.example.rabbitmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Configuration
public class MessagingConfig {

	
	/*
	 * public static final String Queue="ust_queue"; public static final String
	 * Exchange="ust_exchange"; // routing key binds the exchange and queue public
	 * static final String Routing_Key="ust_routingKey";
	 */
	@Value("${ust.rabbitmq.queue}")
     String queueName;

	 @Value("${ust.rabbitmq.exchange}")
	 public static String exchange;

	@Value("${ust.rabbitmq.routingkey}")
	public static String routingkey;
	
	@Bean//java configuration
	public Queue queue() {
		return new Queue(queueName);
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	@Bean
	public Binding binding(Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	
	//advanced messaging queue protocol-amqp-open standard protocol that
	//allows messaging interoperability between systems, regardless of 
	//message broker vendor or platform used
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		//connection factory -factory design pattern,manages connection btwn 
		//producer to consumer,producer to queue,queue to exchange and then to routingkey
		//hides the connection infrastructure
		final  RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(converter());
		return template;
    }
	//spring ioc container will call the funs annotated with @Bean
}
