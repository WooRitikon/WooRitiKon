package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Notice;
import com.example.persistence.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeRepository notiRepo;
	
	@Override// 공지사항 리스트 조회
	public List<Notice> getNoticeList(Notice vo){
		
		return (List<Notice>)notiRepo.findAll();
	}
	
	@Override//  공지사항 작성
	public void writeNotice(Notice vo) {
		notiRepo.save(vo);
	}
	
	@Override//  공지사항 상세조회
	public Notice getNotice(Notice vo) {
		return notiRepo.findById(vo.getNoticecode()).get();
	}
	
	//수정
	@Override
	public void updateNotice(Notice vo) {
		Notice vv = notiRepo.findById(vo.getNoticecode()).get();
		
		vv.setNtitle(vo.getNtitle());
		vv.setNcontent(vo.getNcontent());
		
		notiRepo.save(vv);
	}
	//삭제
}
