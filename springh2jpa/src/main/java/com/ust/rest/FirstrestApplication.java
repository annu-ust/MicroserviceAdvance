package com.ust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Product;

@SpringBootApplication
public class FirstrestApplication  implements CommandLineRunner{
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt=SpringApplication.run(FirstrestApplication.class, args);
		for(String str:args) {
		System.out.println(str);
		}
		
		System.out.println(ctxt.containsBean("productRepositary"));
		System.out.println(ctxt.containsBean("repo"));
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("From command line runner");
		
		List<Product> product = repo.findAll();
		System.out.println(product.size());
		
	}

	

}

