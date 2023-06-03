package com.example.helloclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/api/client")
public class HelloClientResource {
@Autowired
RestTemplate template;

/*
 * @GetMapping public String callServer() { String
 * url="http://localhost:8093/rest/server"; String
 * output=template.getForObject(url, String.class); return output; }
 */
 @GetMapping("/server/status")
public String callServer() {
	String url="http://localhost:8093/rest/server/status";//using gate way port to  call hello service
	String output=template.getForObject(url, String.class);
	return output;
}
 @GetMapping("/billing")
public String callBilling() {
	String url="http://localhost:8093/rest/billing";//using gate way port to  call hello service
	String output=template.getForObject(url, String.class);
	return output;
}
}
