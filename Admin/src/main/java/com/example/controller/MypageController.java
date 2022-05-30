package com.example.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Giftikon;
import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.persistence.GiftikonRepository;
import com.example.service.MypageService;





@Controller
public class MypageController {

	static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired
	private GiftikonRepository giftikonRepo;
	
	@Autowired
	private MypageService mypageService;

	@RequestMapping("/test")
	public void test() {
	}

	// <마이페이지 메인>
	// 이름 가져오기
	@RequestMapping("/mypageMain")
	public void getname(Normalid no, Model m) {
		logger.info("getname controller");
		Normalid no1 = mypageService.getname(no);
		m.addAttribute("normalid", no1);
	}

	// <주문조회>
	// 기프티콘리스트출력
	@RequestMapping("/mypageShoppingList")
	public void getGiftList(Model m, String nid) {
		logger.info("getGiftList controller:"+nid);
		
		List<HashMap<String, Object>> giftSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftSelect(nid);
		for(Object[] giftobj : gift) {
			HashMap<String, Object> gift1 = new HashMap<String, Object>();
			gift1.put("NID", giftobj[0]);
			gift1.put("STARTDATE", giftobj[1]);
			gift1.put("FINALDATE", giftobj[2]);
			gift1.put("PCODE", giftobj[3]);
			gift1.put("PPRICE", giftobj[4]);
			gift1.put("PCATEGORY", giftobj[5]);
			gift1.put("PNAME", giftobj[6]);
			gift1.put("PCONTENT", giftobj[7]);
			gift1.put("GCODE", giftobj[8]);
			
			giftSelect.add(gift1);
		}
		m.addAttribute("giftikon", giftSelect);
	
	}
	//기프티콘 상세보기
	@RequestMapping("/mypageShoppingSet")
	public void getGiftikonSet(Giftikon gi, Model m) {
		logger.info("getGiftikontSet controller");
		Giftikon g = mypageService.getGiftikonSet(gi);
		m.addAttribute("giftikon", g);
		m.addAttribute("product", g.getProduct());
		m.addAttribute("normalid", g.getNormalid());
	}

	// 구매내역보기
//	@RequestMapping("/mypageShoppingAllList")
//	public void getGiftAllList(String nid, Model m) {
//		logger.info("getGiftList controller");
//		Product pr = new Product();
//		List<HashMap<String, Object>> giftSelect = new ArrayList<HashMap<String, Object>>();
//		List<Object[]> gift = mypageService.getProductList(nid);
//		for(Object[] giftobj : gift) {
//			HashMap<String, Object> gift1 = new HashMap<String, Object>();
//			gift1.put("NID", giftobj[0]);
//			gift1.put("STARTDATE", giftobj[1]);
//			gift1.put("FINALDATE", giftobj[2]);
//			gift1.put("PCODE", giftobj[3]);
//			gift1.put("PPRICE", giftobj[4]);
//			gift1.put("PCATEGORY", giftobj[5]);
//			gift1.put("PNAME", giftobj[6]);
//			gift1.put("PCONTENT", giftobj[7]);
//			gift1.put("GCODE", giftobj[8]);
//			
//			giftSelect.add(gift1);
//		}
//		m.addAttribute("GiftikonList", giftSelect);
//	}

	// <포인트조회>
	// 포인트 조회하기
	@RequestMapping("/mypagePointSet")
	public void getPointSet(Normalid no, Model m) {
		logger.info("getPointSet controller");
		m.addAttribute("normalid", mypageService.getname(no));
	}

	// <위시리스트>
	// 장바구니조회
	@RequestMapping("/mypageBasketList")
	public void getBasketList() {
		logger.info("getBasketList controller");
	}

	// 찜한가게
	@RequestMapping("/mypageHeartList")
	public void getHeartList() {
		logger.info("getHeartList controller");
	}

	// <선물함>
	// 받은 선물함
	@RequestMapping("/mypageGetGift")
	public void getGift() {
		logger.info("getGift controller");
	}

	// 보낸 선물함
	@RequestMapping("/mypageSendGift")
	public void sendGift() {
		logger.info("sendGift controller");
	}

	// <회원 정보>
	// 회원 정보 조회
	@RequestMapping("/mypageInfo")
	public void getInfo(Normalid no, Model m) {
		logger.info("getInfo controller");
		m.addAttribute("normalid", mypageService.getNid(no));
	}

	
	  // 회원 정보 수정하기 창 열기
	  @RequestMapping("/mypageInfoUpload")
	  public void infoUpload(Normalid no, Model m) { 
		  logger.info("infoUpload controller");
		  m.addAttribute("normalid",mypageService.getNid(no)); 
	}

	
	  //회원 정보 수정
	 @RequestMapping("/mypageInfoUpdate")
	 public String infoUpdate(Normalid no) {
		 logger.info("infoUpdate controller"); 
		 mypageService.getNidUpdate(no);
		return "/mypageInfo";
	 }
	 

	// 비밀번호 변경 확인
	@RequestMapping("/mypageInfoPass")
	public void infoPass() {
		logger.info("infoPass controller");
	}

	// 비밀번호 변경하기
	@RequestMapping("/mypageInfopassCommit")
	public void infoPassCommit() {
		logger.info("infoPassCommit controller");
	}

	// <회원탈퇴>
	// 회원탈퇴 비밀번호확인
	@RequestMapping("/mypageInfoCancel")
	public void infoCancel() {
		logger.info("infoCancel controller");
	}

	//<바코드구현>


}
