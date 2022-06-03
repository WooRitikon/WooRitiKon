package com.example.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Giftikon;
import com.example.domain.Like;
import com.example.domain.Normalid;
import com.example.persistence.BucketRepository;
import com.example.persistence.GiftikonRepository;
import com.example.persistence.LikeRepository;
import com.example.persistence.MypageMainRepository;
import com.example.service.GifticonService;
import com.example.service.MypageService;





@Controller
public class MypageController {

	static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired
	private GiftikonRepository giftikonRepo;
	
	@Autowired
	private MypageService mypageService;

	@Autowired
	private LikeRepository likeRepo;
	
	@Autowired
	private GifticonService gifticonService;
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	@Autowired
	private BucketRepository bucketRepo;
	
	//이름 가져오기
	@RequestMapping("/mypageMain")
	public void getname(HttpServletRequest request, Model m) {
		logger.info("getname controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("nid", mypageService.getname(nid));
	}
	
	//<주문조회>
	//기프티콘리스트출력

	@RequestMapping("/mypageShoppingList")
	public void getGiftList(Model m, HttpServletRequest request) {
		logger.info("getGiftList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
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
	public void getGiftikonSet(HttpServletRequest request, Giftikon gi, Model m) {
		logger.info("getGiftikontSet controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		Giftikon g = mypageService.getGiftikonSet(gi);
		m.addAttribute("giftikon", g);
		m.addAttribute("product", g.getProduct());
		m.addAttribute("normalid", g.getNormalid());
	}

	// 구매내역보기
	@RequestMapping("/mypageShoppingAllList")
	public void getGiftAllList(HttpServletRequest request, Model m) {
		logger.info("getGiftList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		List<HashMap<String, Object>> giftSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftAllSelect(nid);
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

	// <포인트조회>
	// 포인트 조회하기
	 @RequestMapping("/mypagePointSet") 
	 public void getPointSet(HttpServletRequest request, Model m) { 
		 logger.info("getPointSet controller");
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		 
		 m.addAttribute("normalid", mypageService.getPointSet(nid)); 
		 }
	 
	// <위시리스트>
	// 장바구니조회
	
	  @RequestMapping("/mypageBasketList")
	  public void createOrder(HttpServletRequest request, Model m){
	  logger.info("getBasketList controller");
	  HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		List<HashMap<String, Object>> bucketSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> bucket = bucketRepo.selectBusket(nid);
		for(Object[] bucketobj : bucket) {
			HashMap<String, Object> bucket1 = new HashMap<String, Object>();
			bucket1.put("NID", bucketobj[0]);
			bucket1.put("PNAME", bucketobj[1]);
			bucket1.put("PPRICE", bucketobj[2]);
			bucket1.put("QUANTITY", bucketobj[3]);
	
			
			bucketSelect.add(bucket1);
		}
		m.addAttribute("bucketSelect", bucketSelect);
	  }
	 

	// 찜한가게
	@RequestMapping("/mypageHeartList")
	public void getHeartList(HttpServletRequest request, Model m) {
		logger.info("getHeartList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		List<HashMap<String, Object>> shopHeart = new ArrayList<HashMap<String, Object>>();
		List<Object[]> shop = likeRepo.shopHeart(nid);
		for(Object[] shopobj : shop) {
			HashMap<String, Object> shop1 = new HashMap<String, Object>();
			shop1.put("NID", shopobj[0]);
			shop1.put("BNAME", shopobj[1]);
			shop1.put("BTEL", shopobj[2]);
			shop1.put("HEART", shopobj[3]);
			
			shopHeart.add(shop1);
		}
		m.addAttribute("shopHeart", shopHeart);
	}
	
	//찜한 가게 취소 
	@RequestMapping("/cancelHeart")
	public String shopHeartCancel(Like li, HttpServletRequest request) {
		logger.info("shopHeartCancel controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		mypageService.deleteHeart(li);
		return "redirect:mypageHeartList";
	}
	

	// <선물함>
	// 받은 선물함
	@RequestMapping("/mypageGetGift")
	public void getGift(Model m, HttpServletRequest request) {
		logger.info("getGift controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<HashMap<String, Object>> giftToSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftToSelect(nid);
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
			gift1.put("GIFTSTATE", giftobj[9]);
			gift1.put("SENDERID", giftobj[10]);
			
			giftToSelect.add(gift1);
		}
		m.addAttribute("giftikon", giftToSelect);
	}

	// 보낸 선물함
	@RequestMapping("/mypageSendGift")
	public void sendGift() {
		logger.info("sendGift controller");
	}

	// <회원 정보>
	// 회원 정보 조회
	@RequestMapping("/mypageInfo")
	public void getInfo(HttpServletRequest request, Model m) {
		logger.info("getInfo controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("normalid", mypageService.getNid(nid));
	}

	
	  // 회원 정보 수정하기 창 열기
	  @RequestMapping("/mypageInfoUpload")
	  public void infoUpload(HttpServletRequest request, Model m) { 
		  logger.info("infoUpload controller");
		  HttpSession session = request.getSession();
		  String nid = (String)session.getAttribute("nid");
		  
		  m.addAttribute("normalid",mypageService.getNid(nid)); 
	}

	
	  //회원 정보 수정
	 @RequestMapping("/mypageInfoUpdate")
	 public String infoUpdate(HttpServletRequest request, Normalid no) {
		 logger.info("infoUpdate controller"); 
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		  
		 mypageService.getNidUpdate(no);
		 return "/mypageInfo";
	 }
	 

	// 비밀번호 변경 확인
	@RequestMapping("/mypageInfoPass")
	public void infoPass(HttpServletRequest request, Model m) {
		logger.info("비밀번호 유효성검사 페이지");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		Normalid result = mypageService.getNid(nid);
		
		m.addAttribute("result",result);
	}
	
	// 비밀번호 변경 확인
	@RequestMapping("/mypageInfoPassCheck")
	public String infoPass(HttpServletRequest request, Normalid vo, Model m) {
		logger.info("infoPass controller");
		
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		 vo.setNid(nid);
		 
		 Normalid result = gifticonService.nloginCheck(vo);
		
		 
		 if (result == null) {
			 session.setAttribute("nid", nid);
			return "redirect:mypageInfoPass";
		} else {
			 m.addAttribute("nid",result);
			return "redirect:mypageInfoPassCommit";
		}
		 
		 
		
	
	}

	// 비밀번호 변경하기 
	@RequestMapping("/mypageInfopassCommit")
	public void infoPassCommit(HttpServletRequest request, Model m) {
		logger.info("infoPassCommit controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		
		Normalid result = mypageService.getNid(nid);
		
		
		m.addAttribute("nid",result);	
	}

	 // 비밀번호 변경 업데이트
	 @RequestMapping("/updatePassword")
	 public String updatePassword(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		
		 Normalid result = mypageService.getNid(nid);
		 
		
		 if (result == null) {
			 session.setAttribute("nid", nid);
			 return "redirect:mypageInfopassCommit";
		 } else {
			 result.setNpassword(vo.getNpassword());
			 gifticonService.savenormalId(result);
			 session.invalidate();
			 return "redirect:login";
		 }


	 }
	 
	 //회원 페이지 넘기기
	 @RequestMapping("/mypageInfoCancel")
	 public void mypageInfoCancel(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

			HttpSession session = request.getSession();
			String nid = (String)session.getAttribute("nid");
			
			
			Normalid result = mypageService.getNid(nid);
			
			
			m.addAttribute("nid",result);


	 }
	 
	 //회원탈퇴
	 @RequestMapping("/updateState")
	 public String deleteNormalid(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		
		 Normalid result = mypageService.getNid(nid);
		 
		
		 if (result == null) {
			 session.setAttribute("nid", nid);
			 return "redirect:mypageInfoCancel";
		 } else {
			 result.setNpassword(vo.getNpassword());
			 mypageMainRepo.deleteNormalid(nid);
			 session.invalidate();
			 return "redirect:login";
		 }


	 }

	//<바코드구현>


}
