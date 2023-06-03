package com.ust.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.resource.Product;
import com.ust.rest.services.ProductService;



@RestController
@RequestMapping("/product/api.2.0")
//@Api(value="Product Service API 2.0",description="Rest endpoints for product api")//adding swagger
public class ProductResource {

	//Product is in repository
	@Autowired
	ProductService service;//object of Service class
	@GetMapping
	public String test() {
		return "test()called.....";
	}
	//getting one element
	@GetMapping
	@RequestMapping("/retrive/{productId}")//to get details of one item
	//@ApiOperation(value=" fetch product id and returns the product entity")//additional information about method
	public Product fetchProduct(@PathVariable long productId)
	{
		return service.getProduct(productId);
	}
	//getting all elements
	@GetMapping
	@RequestMapping("/retrive/all")
	//@ApiOperation(value="returns the product entity")//additional information about method
	public List<Product> fetchProduct()
	{
		 return service.getProducts();
		
	}
	//add
	@PostMapping
	@RequestMapping(value="/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	//@ApiOperation(value=" create a product")//additional information about method
	public ResponseEntity<Product>addproduct(@RequestBody Product product){
		boolean result=service.add(product);
		if(result) {
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		}else
			return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	//update
	@PutMapping
	@RequestMapping(value="/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@DeleteMapping
	@RequestMapping(value="/delete/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		service.deleteProduct(productId);
	}
	
}
