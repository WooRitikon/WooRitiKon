package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.chating.vo.Room;
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
	
	//채팅
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		return mv;
	}
	
	/**
	 * 방 페이지
	 * @return
	 */
	@RequestMapping("/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("room");
		return mv;
	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	@RequestMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		return roomList;
	}
	
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@RequestMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	@RequestMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat");
		}else {
			mv.setViewName("room");
		}
		return mv;
	}
}
