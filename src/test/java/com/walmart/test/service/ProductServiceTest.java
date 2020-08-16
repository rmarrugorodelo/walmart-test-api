package com.walmart.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.walmart.test.config.exception.ParameterNotValidException;
import com.walmart.test.data.ProductTestData;
import com.walmart.test.dto.ProductDto;
import com.walmart.test.model.Product;
import com.walmart.test.repository.ProductRepository;
import com.walmart.test.service.ProductService;
import com.walmart.test.service.impl.ProductServiceImpl;
import com.walmart.test.service.rule.GetProductByBrandOrDescriptionStrategy;
import com.walmart.test.service.rule.GetProductByIdStrategy;
import com.walmart.test.service.rule.ProductContext;

public class ProductServiceTest {

	private ProductRepository productRepository;

	private ModelMapper mapper;

	ProductContext productContext;

	private GetProductByIdStrategy getProductById;

	private GetProductByBrandOrDescriptionStrategy getProductByBrandOrDescription;

	private ProductServiceImpl productService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		productRepository = Mockito.mock(ProductRepository.class);
		mapper = new ModelMapper();
		productService = new ProductServiceImpl(productRepository, mapper);

	}

	@Test(expected = ParameterNotValidException.class)
	public void findByParameterWithParameterEmptyTest() {
		productService.findByParameter(ProductTestData.PARAMETER_EMPTY);
		fail();
	}

	
	@Test(expected = ParameterNotValidException.class)
	public void findByParameterWithParameterLengthNotValidTest() {
		productService.findByParameter(ProductTestData.PARAMETER_LENGTH_NO_VALID);
		fail();
	}

	@Test
	public void findByParameterWithIdTest() {
		getProductById = new GetProductByIdStrategy(productRepository);
		productContext = new ProductContext(getProductById);
		String parameterId = ProductTestData.PARAMETER_ID.get();
		Optional<Product> product = Optional.of(ProductTestData.buildModels().get(0));
		when(productRepository.findById(Long.parseLong(parameterId))).thenReturn(product);

		List<ProductDto> products = productService.findByParameter(ProductTestData.PARAMETER_ID);
		assertNotNull(products);
		assertFalse(products.isEmpty());
	}

	@Test
	public void findByParameterTextTest() {
		getProductById = new GetProductByIdStrategy(productRepository);
		productContext = new ProductContext(getProductByBrandOrDescription);
		String parameter = ProductTestData.PARAMETER.get();
		when(productRepository.findByParameter(parameter)).thenReturn(ProductTestData.buildModels());

		List<ProductDto> products = productService.findByParameter(ProductTestData.PARAMETER);
		assertNotNull(products);
		assertFalse(products.isEmpty());
	}

}
