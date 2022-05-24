package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Admin1Controller;
import com.example.domain.Qna;
import com.example.persistence.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService {
	
	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
	
	@Autowired
	private QnaRepository QnaRepo;
	
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
	
	//qna 제목 가져오기
	@Override
	public Qna replyList(Qna q) {
		logger.info("리스트");
		//Qna result = QnaRepo.findById(q.getQcode()).get();
		logger.info("가져오기 :" + q.getNcontent());
		return QnaRepo.findById(q.getQcode()).get();
		
	}
}
