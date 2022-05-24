package com.example.service;

import java.util.List;

import com.example.domain.Normalid;
import com.example.domain.Product;

public interface MypageService {

	//<마이페이지 메인>
	//메인 페이지 이름 가져오기
	Normalid getname(Normalid no);
	
	//<주문조회>
	//기프티콘 목록 조회
	List<Product> getProductList(Product pr);
}
