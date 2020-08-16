package com.walmart.test.service.rule;

import java.util.List;
import java.util.stream.Collectors;

import com.walmart.test.config.exception.ParameterNotValidException;
import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;

public class GetProductByBrandOrDescriptionStrategy extends GetProductStrategy{
	
	private final Double DISCOUNT_PERCENTAGE = 0.50;
	
	private final ProductRepository productRepository;

	public GetProductByBrandOrDescriptionStrategy(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findByParameter(String parameter) {
		if(!isGreaterThanThree(parameter)) {
			throw new ParameterNotValidException("Invalid parameter, parameter is less than allowable minimum of 4");
		}
		List<Product> products = productRepository.findByParameter(parameter);
		if(isPalindrome(parameter)) {
			aplyDiscountsToProducts(products);
		}
		return products;
	}
	
	private Boolean isGreaterThanThree(String parameter) {
		return parameter.length() > 3;
	}
	private Boolean isPalindrome(String parameter) {
		String invested = new StringBuilder(parameter).reverse().toString();
		return parameter.equals(invested);
	}
	
	private void aplyDiscountsToProducts(List<Product> products) {
		products.stream().map(product ->{ 
			Double priceWithDiscount = calculateFiftyPercentDiscount(product.getPrice());
			product.setPrice(priceWithDiscount);
			return product;
		}).collect(Collectors.toList());
	}
	
	private Double calculateFiftyPercentDiscount(Double price) {
		return price * DISCOUNT_PERCENTAGE;
	}

}
