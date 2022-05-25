package com.example.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
	List<Object[]> queryAnnotation(String word);
}
