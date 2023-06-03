package com.example.helloclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@EnableEurekaClient//not need when we use gateway
//commented as the client is before the gateway
@SpringBootApplication
public class HelloclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloclientApplication.class, args);
	}
@Bean
public RestTemplate makeTemplate() {
	return new RestTemplate();
}
/*Rest Template is used to create applications that consume RESTful Web Services.*/
}
