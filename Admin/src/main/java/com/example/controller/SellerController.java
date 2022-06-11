package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Product;
import com.example.domain.Review;
import com.example.domain.Sellerid;
import com.example.service.SellerService;

@Controller
public class SellerController {

	static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	private SellerService sellerService;
	
	//가게 메인페이지
	@RequestMapping("/shopMain")
	public void shopMain(HttpServletRequest request, Model m){
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<Sellerid> seller = sellerService.getSellerList(null);
		List<Sellerid> newsell= new ArrayList<Sellerid>();
		
		for(Sellerid s: seller) {
			if(s.getSid().equals(nid)) {
				newsell.add(s);
				break;
			}
		}
		
		Sellerid a = newsell.get(0);
		
		m.addAttribute("seller", a);
	}
	
	//가게 정보 조회하기
	@RequestMapping("/shopInfo")
	public void getshopInfo(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("seller", sellerService.getshopInfo(nid));
	}
	
	//가게 정보 수정창
	@RequestMapping("/shopInfoMod")
	public void getshopInfoMod(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<Sellerid> seller = sellerService.getSellerList(null);
		List<Sellerid> newsell= new ArrayList<Sellerid>();
		
		for(Sellerid s: seller) {
			if(s.getSid().equals(nid)) {
				newsell.add(s);
				break;
			}
		}
		
		Sellerid a = newsell.get(0);
		
		m.addAttribute("seller", a);
	}
	
	//가게 정보 수정하기
	@RequestMapping("/updateShopMod")
	public String updateshopInfo(HttpServletRequest request, Sellerid se) {
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		  
		 sellerService.updateshopInfo(se);
		 return "redirect:shopInfo";
	 }
	
	//상품 정보 조회하기
	@RequestMapping("/shopProDetails")
	public void getshopProDetails(Product pr, Model m) {
		logger.info("게시물 상세보기");
		Product pr1 = sellerService.getshopProDetails(pr);
		m.addAttribute("product",pr1);
	}
	
	//상품 정보 리스트
	@RequestMapping("/shopProView")
	public void getProList(Model m) {
		Product pr =new Product();
		List<Product> list = sellerService.getProList(pr);
		m.addAttribute("proList", list);
	}
	
	//상품 수정하기 창
	@RequestMapping("/shopProMod")
	public void getProMod(Product pr, Model m) {
		Product pr1 = sellerService.getshopProDetails(pr);
		m.addAttribute("product",pr1);
	}
	
	//상품 등록하기
	@RequestMapping("/savePro")
	public String getshopProReg(Product pr) {
		sellerService.insertPro(pr);
		return "redirect:shopProView";
	}
	
	//상품 삭제하기
	@RequestMapping("/deletePro")
	public String deletePro(Product pr) {
		sellerService.deletePro(pr);
		return "redirect:shopProView";
	}
	
	//상품 수정하기
	@RequestMapping("/updatePro")
	public String updateBoard(Product pr) {
		sellerService.updatePro(pr);
		return "redirect:shopProView";
	}
	
	//가게 리뷰 조회하기
	@RequestMapping("/shopReview")
	public void getshopReview(Model m) {
		logger.info("전체 리뷰 검색");
		Review re =new Review();
		List<Review> list = sellerService.getReviewList(re);
		m.addAttribute("reviewList", list);
	}
	
	//기프티컨 조회
	@RequestMapping(value = "/searchgi", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String searchgi(String gcode) {
		logger.info("기프티콘 확인");
		
		
		return "y";
	}
}
