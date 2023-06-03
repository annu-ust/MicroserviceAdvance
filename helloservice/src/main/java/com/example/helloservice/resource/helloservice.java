package com.example.helloservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/server")
public class helloservice {
	@Autowired
	Environment environment;//is a reference to properties
	
  @Value("message")//giving default value 
  String strMessage;
  @GetMapping
  public String Welcome() {
     return "programming Microservices"+" "+strMessage;
     }
  @GetMapping("/status")
  public String status() {
	  return "Up and Running->>";
  }
  @GetMapping("/environment")
  public String env() {
	  String port=environment.getProperty("server.port");
     return "Programming Microservices @  "+port;
     }
}
