package com.example.service;

import java.util.List;

import com.example.domain.Faq;

public interface FaqService {

	//faq 전체 리스트 출력
	List<Faq> FaqPageList(Faq f);
	
	//faq 등록
	void insertFaq(Faq f);
	
	//faq 삭제
	void deleteFaq(Faq f);
	
	//faq 사용자페이지 리스트 출력
	List<Faq> getFaqList(Faq f);
	
	//faq 상세보기 출력
	Faq FaqPageDetail(Faq f);
	
	//faq 수정하기
	void FaqUpdate(Faq f);
	
}
