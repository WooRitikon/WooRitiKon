package com.example.service;

import java.util.List;

import com.example.domain.Qna;

public interface QnaService {

	//qna 전체 리스트
	List<Qna> getQnaList(Qna vo);
	
	//qna 삭제
	void deleteQna(Qna q);
	
	//제목 가져오기
	Qna replyList(Qna q);

	
	
}
