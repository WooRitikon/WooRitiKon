package com.example.service;

import java.util.List;

import com.example.domain.Qnacomment;

public interface QnacommentService {
	//답글등록
	void insertReply(Qnacomment qc);
	
	//답글보기
	List<Qnacomment> getQcList(Qnacomment qc);

}
