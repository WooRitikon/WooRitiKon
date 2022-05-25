package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Product;
import com.example.domain.Sellerid;
import com.example.persistence.ProductRepository;
import com.example.persistence.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository proRepo;
	
	@Autowired
	SellerRepository sRepo;
	
	@Override
	public List<Product> getProductList(Product pd) {
		return (List<Product>)proRepo.findAll();
	}
	
}
