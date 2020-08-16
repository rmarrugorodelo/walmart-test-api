package com.walmart.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.test.dto.ProductDto;
import com.walmart.test.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> findByParameter(@RequestParam Optional<String> parameter) {
		return ResponseEntity.ok(productService.findByParameter(parameter));
	}
	
}
