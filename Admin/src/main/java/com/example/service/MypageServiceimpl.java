package com.example.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.MypageController;
import com.example.domain.Bucket;
import com.example.domain.Giftikon;
import com.example.domain.Like;
import com.example.domain.Normalid;
import com.example.domain.Buy;
import com.example.domain.Orderlist;
import com.example.persistence.BucketRepository;
import com.example.persistence.GiftikonRepository;
import com.example.persistence.LikeRepository;
import com.example.persistence.MypageMainRepository;
import com.example.persistence.BuyRepository;
import com.example.persistence.OrderlistRepository;


@Service
public class MypageServiceimpl implements MypageService{
	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	@Autowired
	private GiftikonRepository giftikonRepo;
	
	@Autowired
	private LikeRepository likeRepo;
	
	@Autowired
	private OrderlistRepository orderlistRepo;
	

	@Autowired
	private BuyRepository orderRepo;
	
	@Autowired
	private BucketRepository BucketRepo;
	
	
	
	//<마이페이지 메인>
	//이름가져오기 
	@Override
	public Normalid getname(String nid) {
		logger.info("getnid service");
		return mypageMainRepo.findById(nid).get();
	}
	
	//기프티콘 상세조회
	@Override
	public Giftikon getGiftikonSet(Giftikon gi) {
		return giftikonRepo.findById(gi.getGcode()).get();
	}
	
	//<포인트 조회>
	//포인트 금액 조회
	@Override
	public Normalid getPointSet(String nid) {
		return mypageMainRepo.findById(nid).get();
	}
	
	
	//<위시리스트>
	//장바구니 조회
	@Override
	public List<Orderlist> orderlistSet(String nid){
		List<Orderlist> result = (List<Orderlist>)orderlistRepo.findAll();
		return result;
	}
	
	//장바구니 삭제
	@Override
	public void deletebucket(Bucket pname) {
		BucketRepo.delete(pname);
	}
	
	
	
	//찜한 가게 삭제
	@Override
	public void deleteHeart(Like li) {
		likeRepo.delete(li);
	}

	
	//<결제>
	//빈 구매리스트 생성(번호만)
	@Override
	public void updateBuylistNumber() {
	 orderlistRepo.updateBuylistNumber();
	}
	
	//구매리스트 가져오기
	@Override
	public List<Orderlist> buylistget() {
		return (List<Orderlist>)orderlistRepo.findAll();
	}
	//결제완료 시 키프티콘 생성
	@Override
	public void saveGiftcode(Giftikon gi) {
		giftikonRepo.save(gi);
	}
	
	
	//주문리스트 저장
	@Override
	public void orderlistsave(Orderlist vo){
		orderlistRepo.save(vo);
	}
	
	//주문 총 결제액 저장
	public void Ordersave(Buy vo) {
		orderRepo.save(vo);
	}
	
	//주문정보 생성
	@Override
	public void updateOrder(String nid) {
	orderRepo.updateOrderNumber(nid);
	}
	
	//주문정보 받아오기
	@Override
	public List<Buy> Orderget(){
		return (List<Buy>)orderRepo.findAll();
	}
	
	//주문번호에 맞는 주문정보 가져오기
	@Override
	public Buy selectOrderNum(String nid){
		return orderRepo.selectOrderNum(nid);
	}
	//주문정보 가져오기
	@Override
	public List<Buy> OrdergetList(String nid){
		return (List<Buy>)orderRepo.findAll();
	}
	
	//기프티콘 생성
	@Override
	public void giftSet(String nid) {
		giftikonRepo.giftSet(nid);
	}
	
	//포인트 저장
	public void moneysave(Normalid vo) {
		mypageMainRepo.save(vo);
	}
	
	
	//<회원정보 관리>
	//회원정보 조회
	@Override
	public Normalid getNid(String no) {
		return mypageMainRepo.findById(no).get();
	}
	
	
	//회원정보 수정하기 페이지 넘기기

	@Override
	public Normalid infoUpload(Normalid no) { 
		return mypageMainRepo.findById(no.getNid()).get(); 
	}
	 
	
	 //회원정보 수정
	  
	 @Override 
	 public void getNidUpdate(Normalid no) { 
		 Normalid no1 = mypageMainRepo.findById(no.getNid()).get(); 
		 
		 no1.setNid(no.getNid());
		 no1.setNtel(no.getNtel());
		 no1.setNemail(no.getNemail()); 
		 no1.setNpostcode(no.getNpostcode());
		 no1.setNaddress(no.getNaddress()); 
		 no1.setNdaddress(no.getNdaddress());
	 
		 mypageMainRepo.save(no1);
	 }
		//결제 성공시 상태변경
	public void updateOstate(Integer onum) {
		orderRepo.updateOstate(onum);
	}
	
	//결제 성공시 주문리스트 비우기
	public void deleteOrderlist(Integer onum) {
		orderRepo.deleteById(onum);
	}	
	
	//결제 성공시 장바구니 비우기
	public void deletebucket(String nid) {
		BucketRepo.deleteAll();
	}
	
	
	//결제 취소시 테이블 삭제
	public void deleteOnum(Integer onum) {
		orderRepo.deleteAll();
	}
	
	
	 
}
