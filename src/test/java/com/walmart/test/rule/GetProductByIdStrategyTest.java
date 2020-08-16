package com.walmart.test.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.walmart.test.data.ProductTestData;
import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;
import com.walmart.test.service.rule.GetProductByIdStrategy;

public class GetProductByIdStrategyTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private GetProductByIdStrategy getProductById;
	
	@Before
	public void setMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByParameterTest() {
		String parameter = ProductTestData.PARAMETER_ID.get();
		Optional<Product> product = Optional.of(ProductTestData.buildModels().get(0));
		when(productRepository.findById(ProductTestData.ID)).thenReturn(product);
		List<Product> products = getProductById.findByParameter(parameter);
		assertTrue(products.size() > 0);
	}
	
	@Test
	public void findByParameterResultEpmtyTest() {
		Long parameter = ProductTestData.ID;
		Optional<Product> product = Optional.empty();
		when(productRepository.findById(parameter)).thenReturn(product);
		List<Product> products = getProductById.findByParameter(parameter.toString());
		assertTrue(products.isEmpty());
	}

}
