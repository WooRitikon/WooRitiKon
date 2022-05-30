package com.example.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.AdminController;
import com.example.domain.Notice;
import com.example.persistence.ManagerRepository;
import com.example.persistence.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private NoticeRepository notiRepo;
	
	@Autowired
	private ManagerRepository manaRepo;
	
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
		logger.info("serviceimpl noticecode:"+vo.getNoticecode());
		return notiRepo.findById(vo.getNoticecode()).get();
	}
	
	//삭제
	@Override
	public void deleteNotice(Notice vo) {
		notiRepo.delete(vo);
		logger.info("serviceimpl:"+vo.getNtitle());
	}
	
	//수정
	@Override
	public void updateNotice(Notice vo) {
		Notice vv = notiRepo.findById(vo.getNoticecode()).get();
		
		vv.setNtitle(vo.getNtitle());
		vv.setNcontent(vo.getNcontent());
		
		notiRepo.save(vv);
	}
	
}
