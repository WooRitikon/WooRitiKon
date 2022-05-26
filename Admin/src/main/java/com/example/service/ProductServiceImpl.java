package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Product;
import com.example.persistence.ProductRepository;
import com.example.persistence.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository proRepo;
	
	@Override
	public List<Object[]> getProduct(Product pd) {
		return (List<Object[]>)proRepo.getProductList();
	}
	
	@Override
	public void deleteProduct(Product pd) {
		proRepo.delete(pd);
	}
	
}
