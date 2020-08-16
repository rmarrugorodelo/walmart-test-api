package com.walmart.test.service.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;

public class GetProductByIdStrategy extends GetProductStrategy {
	
	private final ProductRepository productRepository;

	public GetProductByIdStrategy(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findByParameter(String parameter) {
		Long id = Long.parseLong(parameter);
		Optional<Product> product = productRepository.findById(id);
		if (!product.isPresent()) {
			return new ArrayList<Product>();
		}
		return Arrays.asList(product.get());
	}

}
