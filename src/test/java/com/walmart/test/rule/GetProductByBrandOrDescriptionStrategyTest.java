package com.walmart.test.rule;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.walmart.test.service.rule.GetProductByBrandOrDescriptionStrategy;
import com.walmart.test.service.rule.GetProductByIdStrategy;

public class GetProductByBrandOrDescriptionStrategyTest {
	

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private GetProductByBrandOrDescriptionStrategy getProductByBrandOrDescription;
	
	@Before
	public void setMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByParameterTest() {
		String parameter = ProductTestData.PARAMETER.get();
		when(productRepository.findByParameter(parameter)).thenReturn(ProductTestData.buildModels());
		List<Product> products = getProductByBrandOrDescription.findByParameter(parameter);
		assertTrue(products.size() > 0);
	}
	
	@Test
	public void findByParameterResultEpmtyTest() {
		String parameter = "aass";
		when(productRepository.findByParameter(parameter)).thenReturn(new ArrayList<Product>());
		List<Product> products = getProductByBrandOrDescription.findByParameter(parameter.toString());
		assertTrue(products.size() == 0);
	}
	
}
