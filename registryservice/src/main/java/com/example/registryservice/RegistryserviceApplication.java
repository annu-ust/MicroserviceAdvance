package com.example.registryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
/*a REST-based server that is used in the AWS Cloud services for load balancing 
 * and failover of middle-tier services*/
@SpringBootApplication
public class RegistryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryserviceApplication.class, args);
	}

}
/* Client-side service discovery allows services to find and communicate with each other
 *  without hard-coding the hostname and port. The only ‘fixed point' in such an
 *   architecture is the service registry, with which each service has to register.
 *  a service registry (Eureka Server)
    a REST service, which registers itself at the registry (Eureka Client)
   a web application, which is consuming the REST service as a registry-aware client 
(Spring Cloud Netflix Feign Client)
 *  
 *   */
 