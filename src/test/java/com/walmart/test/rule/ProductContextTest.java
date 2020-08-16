package com.walmart.test.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.walmart.test.service.rule.ProductContext;

public class ProductContextTest {
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private GetProductByBrandOrDescriptionStrategy getProductByBrandOrDescription;
	
	@Mock
	private GetProductByIdStrategy getProductById;
	
	@InjectMocks
	private ProductContext productContext;
	
	@Before
	public void setMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByParameterByBrandOrDescriptionStrategyTest() {
		String parameter = ProductTestData.PARAMETER.get();
		when(getProductByBrandOrDescription.findByParameter(parameter)).thenReturn(ProductTestData.buildModels()); 
		List<Product> products = productContext.findByParameter(parameter);
		assertTrue(products.size() > 0);
	}
	
	@Test
	public void findByParameterByIdStrategyTest() {
		String parameter = ProductTestData.ID.toString();
		when(getProductById.findByParameter(parameter)).thenReturn(ProductTestData.buildModels()); 
		List<Product> products = productContext.findByParameter(parameter);
		assertTrue(products.size() > 0);
	}
	
	
	@Test
	public void findByParameterByIdStrategyEmptyTest() {
		String parameter = ProductTestData.PARAMETER.toString();
		when(getProductById.findByParameter(parameter)).thenReturn(new ArrayList<Product>()); 
		List<Product> products = productContext.findByParameter(parameter);
		assertTrue(products.size() == 0);
	}

}
