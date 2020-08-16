package com.walmart.test.service.rule;

import java.util.List;

import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;

public class ProductContext {
	
	private final GetProductStrategy getProductStrategy;
	
	public ProductContext(GetProductStrategy getProductStrategy) {
		this.getProductStrategy = getProductStrategy;
	}
	
	public List<Product> findByParameter(String parameter) {
		return getProductStrategy.findByParameter(parameter);
	}
	


}
