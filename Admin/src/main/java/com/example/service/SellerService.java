package com.example.service;

import java.util.List;

import com.example.domain.Product;
import com.example.domain.Review;
import com.example.domain.Sellerid;

public interface SellerService {
	
	//판매자 메인 아이디 가져오기
	Sellerid getname(String sid);
	
	//판매자 전체 리스트
	List<Sellerid> getSellerList(Sellerid sid);
	
	//판매자 상세보기
	Sellerid sellerdetail(Sellerid sid);
	
	//빈 상품 생성
	void saveproduct();

	//판매자 가게 정보보기
	Sellerid getshopInfo(String se);
	
	//판매자 가게 정보 수정 창
	Sellerid getshopInfoMod(Sellerid se);
	
	//판매자 가게 정보 수정하기
	void updateshopInfo(Sellerid se);

	//상품리스트 조회하기
	List<Product> getProList(Product pr);
	
	//상품디테일 조회하기
	Product getshopProDetails(Product pr);
	
	//상품 등록하기
	void insertPro(Product pr);
	
	//상품 수정
	void updatePro(Product pr);
	
	//상품 삭제하기
	void deletePro(Product pr);
	
	//가게 리뷰 조회하기
	List<Review> getReviewList(Review re);

}
