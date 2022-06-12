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
	
	//가게 정보 조회하기 (사용자)
	@RequestMapping("/shopInfoUser")
	public void getshopInfoUser(HttpServletRequest request, Model m, String bcode) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<Sellerid> seller = sellerService.getSellerList(null);
		List<Review> review = sellerService.getReviewList(null);
		List<Review> newreview = new ArrayList<Review>();
		List<Sellerid> newsell= new ArrayList<Sellerid>();
		bcode = "1";
		
		for(Sellerid s: seller) {
			if(s.getBcode().equals(bcode)) {
				newsell.add(s);
				break;
			}
		}
		
		for(Review r: review) {
			if(r.getBcode().equals(bcode)) {
				newreview.add(r);
			}
		}
		
		Sellerid a = newsell.get(0);
		
		m.addAttribute("newreview", newreview);
		m.addAttribute("seller", a);
	}
	
	//리뷰 쓰기 (사용자)
	@RequestMapping("/sendReview")
	public String sendReview(HttpServletRequest request, Review re) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<Sellerid> list = sellerService.getSellerList(null);
		String bcode="0";
		
		for(Sellerid li : list) {
			if(li.getSid().equals(nid)) {
				bcode = li.getBcode();
				
			}
		}
		
		List<Review> list1 = sellerService.getReviewList(null);
		
		for(Review li : list1) {
			if(li.getBcode() == null) {
				li.setBcode(bcode);
				sellerService.sendReview(li);
				break;
			}
		}
		
		return "redirect:shopInfoUser";
	}
	
	//가게 정보 조회하기 (업체)
	@RequestMapping("/shopInfo")
	public void getshopInfo(HttpServletRequest request, Model m) {
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
	public void getProList(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		String bcode="12345678";
		 
		Product pr =new Product();
		List<Product> list = sellerService.getProList(pr);
		List<Sellerid> list1 = sellerService.getSellerList(null);
		List<Product> list2 = new ArrayList<Product>();
		
		for(Sellerid l1 : list1) {
			if(l1.getSid().equals(nid)) {
				bcode = l1.getBcode();
				break;
			}
		}
		
		for(Product li : list) {
			if(li.getBcode().equals(bcode)) {
				list2.add(li);
			}
		}
		m.addAttribute("proList", list2);
	}
	
	//상품 수정하기 창
	@RequestMapping("/shopProMod")
	public void getProMod(Product pr, Model m) {
		Product pr1 = sellerService.getshopProDetails(pr);
		m.addAttribute("product",pr1);
	}
	
	//상품 등록하기
	@RequestMapping("/savePro")
	public String getshopProReg(HttpServletRequest request, Product pr) {
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<Sellerid> list = sellerService.getSellerList(null);
		String bcode="0";
		
		for(Sellerid li : list) {
			if(li.getSid().equals(nid)) {
				bcode = li.getBcode();
			}
		}
		 
		sellerService.insertPro(pr);
		
		List<Product> list1 = sellerService.getProList(null);
		
		for(Product li : list1) {
			if(li.getBcode() == null) {
				li.setBcode(bcode);
				sellerService.insertPro(li);
				
			}
		}
		
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
	public void getshopReview(HttpServletRequest request, Model m) {
		logger.info("전체 리뷰 검색");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		String bcode="0";
		
		Review re = new Review();
		List<Review> list = sellerService.getReviewList(re);
		List<Sellerid> list1 = sellerService.getSellerList(null);
		List<Review> list2 = new ArrayList<Review>();
		
		for(Sellerid l1 : list1) {
			if(l1.getSid().equals(nid)) {
				bcode = l1.getBcode();
				break;
			}
		}
		
		for(Review li : list) {
			if(li.getBcode().equals(bcode)) {
				list2.add(li);
			}
		}
		
		m.addAttribute("reviewList", list2);
	}
	
	//기프티컨 조회
	@RequestMapping(value = "/searchgi", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String searchgi(String gcode) {
		logger.info("기프티콘 확인");
		
		
		return "y";
	}
}
