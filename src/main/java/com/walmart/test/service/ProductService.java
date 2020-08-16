package com.walmart.test.service;

import java.util.List;
import java.util.Optional;

import com.walmart.test.dto.ProductDto;

public interface ProductService {
	
	List<ProductDto> findByParameter(Optional<String> parameter);
	
}
