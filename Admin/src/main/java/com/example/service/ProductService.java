package com.example.service;

import java.util.List;

import com.example.domain.Product;
import com.example.domain.Sellerid;

public interface ProductService {

	//상품 전체보기 리스트
	List<Product> getProductList(Product pd);

}
