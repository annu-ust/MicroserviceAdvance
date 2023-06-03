package com.example.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Welcome {
@GetMapping("/greet")
  public String message() {
	  return "Ola! Como sava";
  }
}
//dockerizing