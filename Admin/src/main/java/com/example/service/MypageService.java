package com.example.service;

import java.util.List;

import com.example.domain.Bucket;
import com.example.domain.Giftikon;
import com.example.domain.Like;
import com.example.domain.Normalid;
import com.example.domain.Order;
import com.example.domain.Orderlist;

public interface MypageService {

	//<마이페이지 메인>
	//메인 페이지 이름 가져오기
	Normalid getname(String nid);
	
	//<주문조회>
	//기프티콘 상세보기
	Giftikon getGiftikonSet(Giftikon gi);
	

	
	//<포인트 조회>
	//포인트 금액 조회하기
	Normalid getPointSet(String nid);
	
	
	//<위시리스트>
	//장바구니 구현
	List<Orderlist> orderlistSet(String nid);
	

	//찜한 가게 삭제
	void deleteHeart(Like li);
	
	//장바구니 삭제
	public void deletebucket(Bucket pname);

	//<결제>
	//빈 구매리스트 생성 
	void updateBuylistNumber();
	
	//구매리스트 번호 가져오기
	Orderlist buylistNumber(Orderlist li);
	
	//<회원정보 관리>
	//회원정보 조회
	Normalid getNid(String no);
	
	//회원정보 수정하기 페이지넘어가기
	Normalid infoUpload(Normalid no);
	
	//회원정보 수정
	void getNidUpdate(Normalid no);


	

	
	
	
	
}
