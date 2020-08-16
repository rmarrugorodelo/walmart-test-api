package com.walmart.test.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.test.config.exception.ParameterNotValidException;
import com.walmart.test.dto.ProductDto;
import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;
import com.walmart.test.service.ProductService;
import com.walmart.test.service.rule.GetProductByBrandOrDescriptionStrategy;
import com.walmart.test.service.rule.GetProductByIdStrategy;
import com.walmart.test.service.rule.ProductContext;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	private final ModelMapper mapper;
	

	public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	@Override
	public List<ProductDto> findByParameter(Optional<String> parameter) {
		if (!isParameterValid(parameter)){
			throw new ParameterNotValidException();
		}
		String paramterStr = parameter.get();
		ProductContext productContext = createInstanceStrategy(paramterStr);
		List<Product> products = productContext.findByParameter(paramterStr);
		return products.stream()
				.map(product -> mapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}
	
	public ProductContext createInstanceStrategy(String parameter) {
		if(isNumber(parameter)) {
			return new ProductContext(new GetProductByIdStrategy(productRepository));
		}
		return new ProductContext(new GetProductByBrandOrDescriptionStrategy(productRepository));
	}
	
	private Boolean isParameterValid(Optional<String> parameter) {
		return parameter.isPresent() && !parameter.get().trim().equals("");
	}
	
	private Boolean isNumber(String parameter) {
		if (parameter == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(parameter);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	
}
