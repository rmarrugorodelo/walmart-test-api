package com.walmart.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.walmart.test.data.ProductTestData;
import com.walmart.test.dto.ProductDto;
import com.walmart.test.service.ProductService;

public class ProductControllerTest {

	@Mock
	private ProductService productService;
	
	@InjectMocks
	private ProductController productController;
	
	@Before
	public void setMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByParameterTest() {
		when(productService.findByParameter(ProductTestData.PARAMETER)).thenReturn(ProductTestData.buildDtos());
		ResponseEntity<List<ProductDto>> response = productController.findByParameter(ProductTestData.PARAMETER);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), ProductTestData.buildDtos());
	}
	
	@Test
	public void findByParameterIdTest() {
		when(productService.findByParameter(ProductTestData.PARAMETER_ID)).thenReturn(ProductTestData.buildDtos());
		ResponseEntity<List<ProductDto>> response = productController.findByParameter(ProductTestData.PARAMETER_ID);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody(), ProductTestData.buildDtos());
	}

}
