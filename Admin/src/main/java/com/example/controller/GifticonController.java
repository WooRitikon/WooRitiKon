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

import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.domain.Sellerid;
import com.example.service.GifticonService;

@Controller
public class GifticonController {
	static final Logger logger = LoggerFactory.getLogger(GifticonController.class);
	
	@Autowired
	private GifticonService gifticonService;
	
	
	//일반회원가입
	@RequestMapping("/normalId")
	public void normalId() {
		logger.info("일반회원 가입");
		
	} 
	
	//일반회원 로그인 화면
	@RequestMapping("/login")
	public void login() {
		logger.info("일반 로그인");
		
	} 
	
	//판매자 로그인화면
	@RequestMapping("/sellerlogin")
	public void sellerlogin() {
		logger.info("판매자 로그인");
		
	} 
	
	//회원가입 선택 페이지
	@RequestMapping("/selectpage")
	public void selectpge() {
		logger.info("회원가입페이지");
	} 
	
	//판매자회원 아이디 찾기 페이지
	@RequestMapping("/searchsid")
	public void searchsid() {
		logger.info("판매자회원 아이디 찾기 페이지");
	} 
	
	//판매자회원 비밀번호 찾기 페이지
	@RequestMapping("/searchspass")
	public void searchspass() {
		logger.info("판매자회원 비밀번호 찾기 페이지");
	}
	
	//가게 검색 리스트 출력
	@RequestMapping("/plist")
	public String plist(HttpServletRequest request,Sellerid vo, Model m) {
		logger.info("가게 검색리스트");
		
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		
		List<Sellerid> seller = gifticonService.searchseller(vo);
		
		m.addAttribute("seller", seller);
		m.addAttribute("nid",nid);
		
		return "productlist";
	}
	
	//판매자회원 아이디 찾기
	@RequestMapping("/sidresult")
	public String sidresult(Sellerid vo, Model m) {
		logger.info("판매자회원 아이디 찾기");
		
		Sellerid result = gifticonService.detectsid(vo);
		
		if (result == null) {
			return "redirect:failsearch";
		}
		
		logger.info(result.getSid());
		
		m.addAttribute("resultsid", result);
		return "sucesssid";
	} 
	
	//판매자 비밀번호 찾기
	@RequestMapping("/spassresult")
	public String spassresult(Sellerid vo, Model m) {
		logger.info("판매자회원 비밀번호 찾기");
		
		Sellerid result = gifticonService.detectsid(vo);
		
		if (result == null) {
			
			return "redirect:failsearch";
		}
		
		logger.info(result.getSid());
		
		m.addAttribute("resultsid", result);
		return "sucessspass";
	} 
	
	//메인페이지
	@RequestMapping("/test")
	public void test(HttpServletRequest request, Model m) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		
		//상품테이블에서 최신 3개 가져오기
		List<Product> product =gifticonService.selectproduct();
		
		//판매자 테이블에서 최신 3개 가져오기
		List<Sellerid> seller =gifticonService.selectSeller();
		
		//핫딜 상품 3개 만들기
		List<Product> pro = gifticonService.selectproduct();
		
		
		m.addAttribute("pro", pro);
		m.addAttribute("seller", seller);
		m.addAttribute("product", product);
		m.addAttribute("nid",nid);
	}
	
	//로그아웃버튼 구현
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:test";
	}
	
	
	//일반 아이디 회원가입 중 아이디 중복확인
	@RequestMapping(value = "/idCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String idCheck(Normalid vo) {
		logger.info("일반 아이디 중복확인");
		Normalid result = gifticonService.idCheck(vo); // 사용가능한 아이디이면 null값이 넘어옴
		String message = ""; // 이메일 사용 가능 여부를 담을 변수

		if (result == null) { // 검색되는 레코드가 없으면 이메일 사용 가능
			message = "Y";
		} // end of if
		return message;
	}
	
	//판매자 아이디 회원가입 중 아이디 중복확인
	@RequestMapping(value = "/selleridCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String selleridCheck(Sellerid vo) {
		logger.info("판매자 아이디 중복확인");
		Sellerid result = gifticonService.sellerCheck(vo); // 사용가능한 아이디이면 null값이 넘어옴
		String message = ""; // 이메일 사용 가능 여부를 담을 변수

		if (result == null) { // 검색되는 레코드가 없으면 이메일 사용 가능
			message = "Y";
		} // end of if
		
		return message;
	}
	

	
	//일반회원 로그인 확인
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpSession session, Normalid vo) {
		logger.info("일반 로그인 확인");
		
		Normalid result = gifticonService.nloginCheck(vo);
		
		if (result == null) {
		
			return "redirect:login";
		}
		
		logger.info(result.getNid());
		
		session.setAttribute("nid", result.getNid());
		return "redirect:test";
		

	}
	

	//상품리스트 확인
//	@RequestMapping("/productlist")
//	public void productlist() {
//		logger.info("상품 리스트");
//		
//		//Normalid result = gifticonService.nloginCheck(vo);
//		
//		
//
//	}
	
	//판매자 로그인 확인
	@RequestMapping("/sellerCheck")
	public String sellerCheck(HttpSession session, Sellerid vo) {
		logger.info("판매자 로그인 확인");
		
		Sellerid result = gifticonService.sloginCheck(vo);
		
		if (result == null) {
		
			return "redirect:sellerlogin";
		}
		
		
		session.setAttribute("nid", result.getSid());
		return "redirect:test";
		

	}
	
	
	//일반회원 아이디 찾기
	@RequestMapping("/nidresult")
	public String nidresult(Normalid vo, Model m) {
		logger.info("일반회원 아이디 찾기");
		
		Normalid result = gifticonService.detectnid(vo);
		
		if (result == null) {
			
			return "redirect:failsearch";
		}
		
		logger.info(result.getNid());
		
		m.addAttribute("resultnid", result);
		return "sucessnid";
	} 
	
	//특정 가게 검색
	@RequestMapping("/searchstore")
	public String searchstore(String check, Model m){
		logger.info("가게 검색 하기");
		List<Sellerid> re = gifticonService.allseller();
		List<Sellerid> la = new ArrayList<Sellerid>();
		
		for(Sellerid ck : re) {
			if(ck.getBname().equals(check)) {
				la.add(ck);
			}
		}
		
		m.addAttribute("seller", la);
		
		return "productlist";
	}
	
	//일반회원 비밀번호 찾기
	@RequestMapping("/npassresult")
	public String npassresult(Normalid vo, Model m) {
		logger.info("일반회원 비밀번호 찾기");
		
		Normalid result = gifticonService.detectnpass(vo);
		
		if (result == null) {
			
			return "redirect:failsearch";
		}
		
		logger.info(result.getNid());
		
		m.addAttribute("resultnid", result);
		return "sucessnpass";
	} 
	
	//일반회원 아이디 찾기 성공페이지!!
	@RequestMapping("/sucessnid")
	public void sucessnid() {
		logger.info("일반회원 아이디 찾기 성공");
	} 
	
	//일반회원 비밀번호 찾기 페이지
	@RequestMapping("/searchnpass")
	public void searchnpass() {
		logger.info("일반회원 비밀번호 찾기 페이지");
	} 
	
	//일반회원 아이디 찾기 페이지
	@RequestMapping("/searchnid")
	public void searchnid(Normalid vo) {
		logger.info("일반회원 아이디 찾기 페이지");
	} 
	
	
	@RequestMapping("/detectnid")
	public void detectnid(Normalid vo) {
		
	} 
	
	//일반회원 회원가입 정보 저장
	@RequestMapping("/savenormalId")
	public String savenormalId(Normalid vo) {
		logger.info("일반 회원가입 작성완료");
		
		gifticonService.savenormalId(vo);
		
		return "login";
	} 
	
	//판매자회원 회원가입 정보 저장
	@RequestMapping("/savesellerId")
	public String savesellerId(Sellerid vo) {
		logger.info("판매자 회원가입 작성완료");
		
		gifticonService.savesellerId(vo);
		
		return "login";
	} 
	
	//판매자 회원가입 페이지
	@RequestMapping("/sellerId")
	public void sellerId() {
		logger.info("판매회원가입");
	} 
	
	//판매자 회원가입 페이지
	@RequestMapping("/failsearch")
	public void failsearch() {
		logger.info("찾기 인증 실패 페이지");
	} 
}
