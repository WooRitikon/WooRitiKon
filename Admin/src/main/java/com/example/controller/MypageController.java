package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.service.MypageService;

@Controller
public class MypageController {

	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageService mypageService;
	
	@RequestMapping("/test")
	public void test() {
	}
	//<마이페이지 메인>
		//이름 가져오기
		@RequestMapping("/mypageMain")
		public void getname(Normalid no, Model m) {
			logger.info("getname controller");
			Normalid no1 = mypageService.getname(no);
			m.addAttribute("normalid",no1);
		}
	
	//<주문조회>
	//기프티콘리스트출력
	@RequestMapping("/mypageShoppingList")
	public void getGiftList(Model m) {
		logger.info("getGiftList controller");
		Product pr = new Product();
		List<Product> list = mypageService.getProductList(pr);
		m.addAttribute("productList",list);
	}
	
	//기프티콘상세보기페이지
	@RequestMapping("/mypageShoppingSet")
	public void setGiftSet(Product pr, Model m) {
		logger.info("setGiftSet controller");
		m.addAttribute("product", mypageService.getProductSet(pr));
	}
	
	//구매내역보기
	@RequestMapping("/mypageShoppingAllList")
	public void getGiftAllList(Model m) {
		logger.info("getGiftList controller");
		Product pr = new Product();
		List<Product> list = mypageService.getProductList(pr);
		m.addAttribute("productList",list);
	}
	
	//<포인트조회>
	//포인트 조회하기
	@RequestMapping("/mypagePointSet")
	public void getPointSet(Normalid no, Model m) {
		logger.info("getPointSet controller");
		//m.addAttribute("normalid",mypageService.getname(no));
	}
	
	
	//<위시리스트>
	//장바구니조회
	@RequestMapping("/mypageBasketList")
	public void getBasketList() {
		logger.info("getBasketList controller");
	}
	
	//찜한가게
	@RequestMapping("/mypageHeartList")
	public void getHeartList() {
		logger.info("getHeartList controller");
	}
	
	
	//<선물함>
	//받은 선물함
	@RequestMapping("/mypageGetGift")
	public void getGift() {
		logger.info("getGift controller");
	}
	
	//보낸 선물함
	@RequestMapping("/mypageSendGift")
	public void sendGift() {
		logger.info("sendGift controller");
	}
	
	
	//<회원 정보>
	//회원 정보 조회
	@RequestMapping("/mypageInfo")
	public void getInfo() {
		logger.info("getInfo controller");
	}
	
	//회원 정보 수정
	@RequestMapping("/mypageInfoUpload")
	public void infoUpload() {
		logger.info("infoUpload controller");
	}
	
	//비밀번호 변경 확인
	@RequestMapping("/mypageInfoPass")
	public void infoPass() {
		logger.info("infoPass controller");
	}
	
	//비밀번호 변경하기
	@RequestMapping("/mypageInfopassCommit")
	public void infoPassCommit() {
		logger.info("infoPassCommit controller");
	}
	
	//<회원탈퇴>
	//회원탈퇴 비밀번호확인
	@RequestMapping("/mypageInfoCancel")
	public void infoCancel() {
		logger.info("infoCancel controller");
	}
	
	
}
