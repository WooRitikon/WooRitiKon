package com.example.service;

import java.util.List;

import com.example.domain.Notice;

public interface NoticeService {
	
	// 공지사항 전체 리스트 조회
	List<Notice> getNoticeList(Notice vo);
	
	// 공지사항 작성 
	void writeNotice(Notice vo);
	
	// 공지사항 상세조회
	Notice getNotice(Notice vo);
	   
	// 공지사항 수정
	void updateNotice(Notice vo);
}
