package com.example.Product.service;

import java.util.List;

import com.example.Product.resource.Product;

public interface ProductService {
	List<Product> findAll();
	List<Product> findByCategory(String category);
	Product findById(int id);
}
