package com.walmart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.walmart.test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

	@Query("select p from products p WHERE p.brand  like %:parameter% or p.description like %:parameter%")
	public List<Product> findByParameter(@Param("parameter") String parameter);
	
}
