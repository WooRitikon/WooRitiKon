package com.example.service;


import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.MypageController;
import com.example.domain.Giftikon;
import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.persistence.GiftikonRepository;
import com.example.persistence.MypageMainRepository;
import com.example.persistence.MypageProductRepository;

@Service
public class MypageServiceimpl implements MypageService{
	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	@Autowired
	private MypageProductRepository mypageProductRepo;
	
	@Autowired
	private GiftikonRepository giftikonRepo;
	
	//<마이페이지 메인>
	//이름가져오기 
	@Override
	public Normalid getname(Normalid no) {
		logger.info("getnid service");
		return mypageMainRepo.findById(no.getNid()).get();
	}
	
	//<주문조회>
	//기프티콘 상세조회
	@Override
	public Giftikon getGiftikonSet(Giftikon gi) {
		return giftikonRepo.findById(gi.getGcode()).get();
	}
	
	//기프티콘 목록 조회
	//@Override
	/*
	 * public List<HashMap> getProductList(String nid){ return
	 * giftikonRepo.findById(nid).get(); }
	 */
	

	
	
	//<포인트 조회>
	//포인트 금액 조회
	@Override
	public Normalid getPointSet(Normalid no) {
		return mypageMainRepo.findById(no.getNid()).get();
	}
	
	
	//<회원정보 관리>
	//회원정보 조회
	@Override
	public Normalid getNid(Normalid no) {
		return mypageMainRepo.findById(no.getNid()).get();
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
	 
}
