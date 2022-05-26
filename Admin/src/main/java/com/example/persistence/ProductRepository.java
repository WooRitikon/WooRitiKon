package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query(value = "SELECT p.pcategory, p.pname, p.pprice, s.sid, p.pgiftcode FROM product p INNER JOIN sellerid s ON p.bcode=s.bcode", nativeQuery = true)
	List<Object[]> getProductList();	

}
