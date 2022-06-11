package com.example.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
//	@Query(value = "SELECT p.pcode, p.pcategory, p.pname, p.pprice, s.sid FROM product p INNER JOIN sellerid s ON p.bcode=s.bcode", nativeQuery = true)
//	List<Object[]> getProductList();	

	@Query(value = "INSERT into product(bcode, pprice, pname, pcategory, pcontent, shotimage, originimage)"
			+ "	VALUES (null,null,null,null,null,null,null) ",nativeQuery = true)
	void insertproduct();	
	
	
}
