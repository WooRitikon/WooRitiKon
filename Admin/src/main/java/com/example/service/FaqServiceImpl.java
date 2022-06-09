package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.CustomerCenterController;
import com.example.domain.Faq;
import com.example.persistence.FaqRepository;

@Service
public class FaqServiceImpl implements FaqService {
	
	static final Logger logger = LoggerFactory.getLogger(CustomerCenterController.class);
	
	@Autowired
	FaqRepository faqRepo;
	
	//faq 사용자리스트 출력
	public List<Faq> FaqPageList(Faq f) {
		logger.info("faq 리스트");
		return (List<Faq>)faqRepo.findAll();
	}
	
	//faq 등록
	public void insertFaq(Faq f) {
		logger.info("faq 등록");
		faqRepo.save(f);
	}
	
	//faq 삭제
	public void deleteFaq(Faq f) {
		logger.info("faq 삭제");
		faqRepo.delete(f);
	}
	
	//faq 관리자페이지 출력
	public List<Faq> getFaqList(Faq f) {
		logger.info("faq 사용자 리스트");
		return (List<Faq>)faqRepo.findAll();
	}
	
	//faq 사용자페이지 상세보기
	public Faq FaqPageDetail(Faq f) {
		logger.info("faq 상세보기");
		return faqRepo.findById(f.getFcode()).get();
	}
	
	//faq 수정하기
	public void FaqUpdate(Faq f) {
		logger.info("faq 수정하기");
		Faq faq = faqRepo.findById(f.getFcode()).get();
		faq.setFtype(f.getFtype());
		faq.setFtitle(f.getFtitle());
		faq.setFcontent(f.getFcontent());
		
		faqRepo.save(faq);
	}
	
}
