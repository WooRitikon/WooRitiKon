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
	
	//상품 전체 리스트
	@Override
	public List<Product> getProductList(Product pd) {
		return (List<Product>)proRepo.findAll();
	}
	
	//상품 삭제
	@Override
	public void deleteProduct(Product pd) {
		proRepo.delete(pd);
	}
	
}
