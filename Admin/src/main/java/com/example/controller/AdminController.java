package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Manager;
import com.example.domain.Notice;
import com.example.service.NoticeService;

@Controller
public class AdminController {
	static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private NoticeService notiservice;
	
	@RequestMapping("/{step}")
	public void viewPage(@PathVariable String step) {
		//return "/board/" + step;
	}	
	
	//공지사항 리스트 전체 조회
	@RequestMapping("getNoticeList")   
	public void getNoticeList(Model m) {
		logger.info("전체 공지 검색");
		Notice vo = new Notice();
		List<Notice> list = notiservice.getNoticeList(vo);
		m.addAttribute("noticeList", list);
	}
	
	//공지사항 작성
	@RequestMapping("noticeWrite")
	public String insertBoard(Notice vo) {
		Manager mg = new Manager();
		notiservice.writeNotice(vo);
		vo.setMcode(mg.getMcode());
		return "redirect:getNoticeList";
	}
	
	//공지사항 상세조회
	@RequestMapping("noticeRead")
	public void getNotice(Notice vo, Model m) {
		logger.info("게시물 상세보기");
		Notice vo1 = notiservice.getNotice(vo);
		m.addAttribute("notice",vo1);
	}
	
	//공지사항 수정
	/*
	@RequestMapping("updateNotice")
	public void updateNotice(Notice vo, Model m) {
		logger.info("게시물 수정 페이지");
		Notice vvo = notiservice.getNotice(vo);
		m.addAttribute("notice",vvo);
	}
	
	@RequestMapping("modifyNotice")
	public String modifyNotice(Notice vo, Model m) {
		notiservice.updateNotice(vo);
		return "redirect:getNoticeList";
	}*/
	
	
	@RequestMapping("deleteNotice")
	public String deleteNotice(Notice vo) {
		notiservice.deleteNotice(vo);
		logger.info("Controller delete:"+vo.getNtitle());
		return "redirect:getNoticeList";
	}
}
