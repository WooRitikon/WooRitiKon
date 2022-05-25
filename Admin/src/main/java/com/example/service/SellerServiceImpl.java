package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Admin1Controller;
import com.example.domain.Sellerid;
import com.example.persistence.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService{
	
	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
	
	@Autowired
	SellerRepository sellerRepo;
	
	//판매자 전체 리스트
	@Override
	public List<Sellerid> getSellerList(Sellerid sid) {
		logger.info("판매자 전체 리스트");
		return (List<Sellerid>)sellerRepo.findAll();
		
	}
	
	@Override
	public Sellerid sellerdetail(Sellerid sid) {
		logger.info("판매자 상세보기");
		return sellerRepo.findById(sid.getBcode()).get();
	}


}
