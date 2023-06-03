package com.ust.rest.resource;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity//telling the persistent api to create a table with same name
//a class who's object should be persistent
public class Product {
	@Id//to give primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)//generate automatic primary key
	//auto is the default generation type/strategy(when a strategy is not specified)
	//generation type is a strategy which the jpa should use/follow to generate primary key values.
	//when the underline db is mysql, generation type.auto means the jpa will create a
	//	hibernate sequence in the db for the generation of primary keys.
	//Hibernate: select next_val as id_val from hibernate_sequence for update
//	Hibernate: update hibernate_sequence set next_val= ? where next_val=?
//	Hibernate: insert into product (description, name, price, qty, product_id)
	//values (?, ?, ?, ?, ?)
//in identity we shouldnot use ith ddl-auto property,and implecityily
	//check the ai box in table
//.identity:-for this strategy to work 1st we have to create a table in mysql 
   //and explicitily specify auto increment (Ai) column as checked for primary key
//and in application.property file spring.jpa.hibernate.ddl-auto=update,this should not be set
	//if it is set it should have value as update
	//@Column(name="productid") to change the colum name in database
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private int qty;
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
