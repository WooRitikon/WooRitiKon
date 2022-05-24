package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.MypageController;
import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.persistence.MypageMainRepository;
import com.example.persistence.MypageProductRepository;

@Service
public class MypageServiceimpl implements MypageService{
	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	@Autowired
	private MypageProductRepository mypageProductRepo;
	
	
	//<마이페이지 메인>
	//이름가져오기
	@Override
	public Normalid getname(Normalid no) {
		logger.info("getnid service");
		return mypageMainRepo.findById(no.getNid()).get();
	}
	
	//<주문조회>
	//기프티콘 목록 조회
	@Override
	public List<Product> getProductList(Product pr){
		return (List<Product>)mypageProductRepo.findAll();
	}
	
	
}
