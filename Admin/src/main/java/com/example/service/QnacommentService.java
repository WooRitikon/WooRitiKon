package com.example.service;

import java.util.List;

import com.example.domain.Qnacomment;

public interface QnacommentService {

	//답글등록
	void insertReply(Qnacomment qc);
	
	//관리자 답글 상세보기
	Qnacomment getQcDetail(Qnacomment qc);
	
	//사용자 답글보기
	List<Qnacomment> getQcList(Qnacomment qc);
	
	//사용자 댓글 전체가져오기
	List<Qnacomment> selectQcList();
}

