package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Admin1Controller;
import com.example.domain.Qna;
import com.example.persistence.QnaRepository;
import com.example.persistence.QnacommentRepository;

@Service
public class QnaServiceImpl implements QnaService {
	
	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
	
	@Autowired
	private QnaRepository QnaRepo;
	
	@Autowired
	private QnacommentRepository qcRepo;
	
	//qna 전체리스트
	@Override
	public List<Qna> getQnaList(Qna vo) {
		logger.info("리스트");
		return (List<Qna>)QnaRepo.findAll();
	}
	

	//qna 삭제
	@Override
	public void deleteQna(Qna q) {
		logger.info("삭제");
		QnaRepo.delete(q);
	}
	
	//qna 내용 가져오기
	@Override
	public Qna replyList(Qna q) {
		logger.info("qna 내용 가져오기");
		return QnaRepo.findById(q.getQcode()).get();
		
	}
	
	//qna 상세보기
	@Override
	public List<Object[]> getQnaDetail(int qcode) {
		logger.info("qna 상세보기");
		return qcRepo.findByqcode(qcode);
		
	}
	
	//qna 수정 값 가져오기
	@Override
	public Qna getQnaUpdate(Qna q) {
		logger.info("qna 수정 값 가져오기");
		return QnaRepo.findById(q.getQcode()).get();
	}
	
	
	//qna 수정하기
	@Override
	public void qnaUpdate(Qna q){
		logger.info("qna 수정하기");
		Qna qna1 = QnaRepo.findById(q.getQcode()).get();
		qna1.setNtitle(q.getNtitle());
		qna1.setNcontent(q.getNcontent());
		
		QnaRepo.save(qna1);
	}
	
	//qna 어드민 상세보기
	@Override
	public void selectUpdate(Qna q) {
		QnaRepo.save(q);
	}
	
	//qna 고객페이지 삭제하기
	@Override
	public void qnaDelete(Qna q) {
		logger.info("qna 삭제하기");
		QnaRepo.delete(q);
	}
	
	//qna 등록
	@Override
	public void insertQna(Qna q) {
		logger.info("qna 등록하기");
		QnaRepo.save(q);
	}
	
//	//qna 어드민 상세보기
//	@Override
//
//	public Qna getQnaDetail(Qna q) {
//		logger.info("qna 상세보기");
//		return QnaRepo.findById(q.getQcode()).get();
//		
//	}
	
	//qna 어드민 상세보기
	@Override

	public Qna getQnaDetail(Qna q) {
		logger.info("qna 상세보기");
		return QnaRepo.findById(q.getQcode()).get();
		
	}
}

