package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.service.MypageService;

@Controller
public class MypageController {

	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService mypageService;
	
	
	//<마이페이지 메인>
	//이름 가져오기
	@RequestMapping("/mypageMain")
	public void getname(Normalid no, Model m) {
		logger.info("getname controller");
		Normalid no1 = mypageService.getname(no);
		m.addAttribute("normalid",no1);
	}
	
	@RequestMapping("/test")
	public void test() {
		//logger.info("getname controller");
		//Normalid no1 = mypageService.getname(no);
		//m.addAttribute("normalid",no1);
	}
	//<주문조회>
	//기프티콘리스트출력
	@RequestMapping("/mypageShoppingList")
	public void getGiftList(Model m) {
		logger.info("getGiftList controller");
		Product pr = new Product();
		List<Product> list = mypageService.getProductList(pr);
		m.addAttribute("productList",pr);
	}
	
}
