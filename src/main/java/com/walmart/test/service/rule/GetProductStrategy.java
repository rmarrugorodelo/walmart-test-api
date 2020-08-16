package com.walmart.test.service.rule;

import java.util.List;

import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;

public abstract class GetProductStrategy {
	
	public abstract List<Product> findByParameter(String parameter);
	
}
