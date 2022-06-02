package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Product;
import com.example.domain.Review;
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
	public void getProList(Model m) {
		Product pr =new Product();
		List<Product> list = sellerService.getProList(pr);
		m.addAttribute("proList", list);
	}
	
	@RequestMapping("/savePro")
	public String getshopProReg(Product pr) {
		sellerService.insertPro(pr);
		return "redirect:shopProView";
	}
	
	@RequestMapping("/shopReview")
	public void getshopReview(Model m) {
		logger.info("전체 리뷰 검색");
		Review re =new Review();
		List<Review> list = sellerService.getReviewList(re);
		m.addAttribute("reviewList", list);
	}
}
