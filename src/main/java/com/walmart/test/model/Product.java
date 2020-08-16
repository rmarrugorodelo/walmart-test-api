package com.walmart.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.walmart.test.dto.ProductDto;

import lombok.Data;

@Data
@Entity(name = "products")
public class Product {
	
	@Id
	private Long id;
	
	private String brand;
	
	private String description;
	
	private String image;
	
	private Double price;
	
	
}
