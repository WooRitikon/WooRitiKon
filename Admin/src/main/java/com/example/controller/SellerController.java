package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Sellerid;
import com.example.service.SellerService;

@Controller
public class SellerController {

	static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	private SellerService sellerService;
	
	@RequestMapping("/product-details")
	public void getproduct() {
	}
	
	@RequestMapping("/shopInfo")
	public void getmyshopInfo() {
	}
	
	@RequestMapping("/shopInfoMod")
	public void getshopInfoMod(Sellerid sid, Model m) {
		logger.info("게시물 상세보기");
		Sellerid vo1 = sellerService.selectshopInfo(sid);
		m.addAttribute("Seller",vo1);
	}
	
	@RequestMapping("/shopProView")
	public void getmyproduct() {
	}
	
	@RequestMapping("/shopProReg")
	public void getshopProReg() {
	}
	
	@RequestMapping("/shopReview")
	public void getshopReview() {
	}
}
