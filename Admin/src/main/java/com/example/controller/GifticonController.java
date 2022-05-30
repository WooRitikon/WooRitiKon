package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Normalid;
import com.example.service.GifticonService;

@Controller
//@RequestMapping("/Main")
public class GifticonController {
	static final Logger logger = LoggerFactory.getLogger(GifticonController.class);
	
	@Autowired
	private GifticonService gifticonService;
	
	@RequestMapping("/normalId")
	public void normalId() {
		logger.info("일반회원 가입");
		
	} 
	
	@RequestMapping("/login")
	public void login() {
		logger.info("로그인");
		
	} 
	
	@RequestMapping("/selectpage")
	public void selectpge() {
		logger.info("회원가입페이지");
		
		
	} 
	
	@RequestMapping("/test")
	public void test() {
	}
	
	@RequestMapping("/loginsu")
	public void loginsu(Model m) {
	}
	
	
	@RequestMapping(value = "/idCheck", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String idCheck(Normalid vo) {
		logger.info("아이디 중복확인");
		Normalid result = gifticonService.idCheck(vo); // 사용가능한 아이디이면 null값이 넘어옴
		String message = ""; // 이메일 사용 가능 여부를 담을 변수

		if (result == null) { // 검색되는 레코드가 없으면 이메일 사용 가능
			message = "Y";
		} // end of if
		return message;
	}
	
//	@RequestMapping(value = "/loginCheck", produces = "application/text;charset=utf-8")
//	@ResponseBody
//	public String loginCheck(Normalid vo, Model m) {
//		logger.info("로그인 확인");
//		Normalid result = gifticonService.nloginCheck(vo); // 사용가능한 이메일이면 null값이 넘어옴
//		String message = ""; // 이메일 사용 가능 여부를 담을 변수
//
//		if (result != null) { // 검색되는 레코드가 없으면 이메일 사용 가능
//			message = "Y";
//		}
//		
//		return message;
//	}
	
	//로그인
	@RequestMapping("/loginCheck")
	public String loginCheck(Normalid vo, Model m) {
		logger.info("로그인 확인");
		
		Normalid result = gifticonService.nloginCheck(vo);
		
		if (result == null) {
		
			return "login";
		}
		
		
		m.addAttribute("id", result);
		return "test";
		

	}
	
	
	@RequestMapping("/savenormalId")
	public String savenormalId(Normalid vo) {
		logger.info("일반회원가입 작성완료");
		
		gifticonService.savenormalId(vo);
		
		return "select";
	} 
	
	@RequestMapping("/sellerId")
	public void sellerId() {
		logger.info("판매회원가입");
	} 
	
	@RequestMapping("/select")
	public void select() {
		logger.info("회원가입 선택");
	} 
}
