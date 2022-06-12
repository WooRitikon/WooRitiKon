package com.example.service;

import com.example.domain.Normalid;
import com.example.domain.Sellerid;

public interface GifticonService {
	
	//일반회원 아이디 저장(회원가입)
	public void savenormalId(Normalid vo);
	
	
	public Normalid idCheck(Normalid vo);
	
	public Sellerid sellerCheck(Sellerid vo);
	
	//일반회원 로그인 유효성 검사
	public Normalid nloginCheck(Normalid vo);

	
	//판매자회원 로그인 유효성 검사
	public Sellerid sloginCheck(Sellerid vo);
	
	//판매자회원 아이디 저장(회원가입)
	public void savesellerId(Sellerid vo);
	
	//일반회원 아이디 찾기
	public Normalid detectnid(Normalid vo);
	
	//일반회원 비밀번호 찾기
	public Normalid detectnpass(Normalid vo);
	
	//판매자회원 아이디 찾기
	public Sellerid detectsid(Sellerid vo);
	
	//판매자회원 비밀번호 찾기
	public Sellerid detectspass(Sellerid vo);
}
