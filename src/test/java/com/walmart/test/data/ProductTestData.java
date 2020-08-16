package com.walmart.test.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.walmart.test.dto.ProductDto;
import com.walmart.test.model.Product;

public class ProductTestData {
	
	private static final String BRAND = "daad";
	
	private static final String DESCRIPTION = "vangde oswss";

	private static final String IMAGE = "www.lider.cl/catalogo/images/furnitureIcon.svg";
	
	public static final Long ID = 10L;
	
	public static final Optional<String> PARAMETER = Optional.of(BRAND);
	
	public static final Optional<String> PARAMETER_EMPTY = Optional.empty();
	
	public static final Optional<String> PARAMETER_LENGTH_NO_VALID = Optional.of("asd");
	
	public static final Optional<String> PARAMETER_ID = Optional.of(ID.toString());

	public static List<ProductDto> buildDtos() {
		ProductDto product = new ProductDto();
		product.setBrand(BRAND);
		product.setDescription(DESCRIPTION);
		product.setImage(IMAGE);
		product.setPrice(798724D);
		return Arrays.asList(product);
	}

	public static List<Product> buildModels() {
		Product product = new Product();
		product.setId(ID);
		product.setBrand(BRAND);
		product.setDescription(DESCRIPTION);
		product.setImage(IMAGE);
		product.setPrice(798724D);
		return Arrays.asList(product);
	}
	
}
