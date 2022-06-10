package com.example.service;

import java.util.List;

import com.example.domain.Qna;
import com.example.domain.Qnacomment;

public interface QnaService {

	//qna 전체 리스트
	List<Qna> getQnaList(Qna vo);
	
	//qna 삭제
	void deleteQna(Qna q);
	
	//제목 가져오기
	Qna replyList(Qna q);

	//Qna 상세보기
	List<Object[]> getQnaDetail(int qCode);
	
	//Qna 수정 값 가져오기
	Qna getQnaUpdate(Qna q);
	
	//Qna 수정하기
	void qnaUpdate(Qna q);
	
	//qna 고객페이지 삭제
	void qnaDelete(Qna q);
	
	//qna 등록
	void insertQna(Qna q);
	
}
