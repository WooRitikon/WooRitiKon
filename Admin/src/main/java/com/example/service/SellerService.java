package com.example.service;

import java.util.List;

import com.example.domain.Sellerid;

public interface SellerService {
	
	//판매자 전체 리스트
	List<Sellerid> getSellerList(Sellerid sid);
	
	//판매자 상세보기
	Sellerid sellerdetail(Sellerid sid);

	//판매자 가게 정보보기
	Sellerid selectshopInfo(Sellerid sid);
	


}
