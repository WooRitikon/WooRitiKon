package com.example.service;

import java.util.List;

import com.example.domain.Product;
import com.example.domain.Review;
import com.example.domain.Sellerid;

public interface SellerService {
	
	//판매자 전체 리스트
	List<Sellerid> getSellerList(Sellerid sid);
	
	//판매자 상세보기
	Sellerid sellerdetail(Sellerid sid);

	//판매자 가게 정보보기
	Sellerid getshopInfo(Sellerid sid);

	//가게 상품리스트 조회하기
	List<Product> getProList(Product pr);
	
	//가게 상품 조회하기
	Product getshopProDetails(Product pr);
	
	//가게 상품 등록하기
	void insertPro(Product pr);
	
	//가게 리뷰 조회하기
	List<Review> getReviewList(Review re);

}
