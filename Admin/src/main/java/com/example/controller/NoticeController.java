package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Notice;
import com.example.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService notiservice;
	
	@RequestMapping("noticePage")   
	public void getNoticeList(Model m) {
		Notice vo = new Notice();
		List<Notice> list = notiservice.getNoticeList(vo);
		m.addAttribute("noticeList", list);
	}
	
	@RequestMapping("noticePageDetail")
	public void getNotice(Notice vo, Model m) {
		Notice vo1 = notiservice.getNotice(vo);
		m.addAttribute("notice",vo1);
	}
	
}
