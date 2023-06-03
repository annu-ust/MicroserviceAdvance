package com.example.helloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
/* it can be a microservice that is ready to work so it registers 
 * itself to the Eureka server e.g. an API for some app,
 * or some application that goes to the server and asks for
 *  directions to a specific microservice.*/
@SpringBootApplication
public class HelloserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloserviceApplication.class, args);
	}

}
