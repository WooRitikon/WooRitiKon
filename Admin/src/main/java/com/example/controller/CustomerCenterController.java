package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Faq;
import com.example.domain.Normalid;
import com.example.domain.Notice;
import com.example.domain.Qna;
import com.example.domain.Qnacomment;
import com.example.service.FaqService;
import com.example.service.NoticeService;
import com.example.service.QnaService;
import com.example.service.QnacommentService;

@Controller
public class CustomerCenterController {
	@Autowired
	private NoticeService notiservice;
	@Autowired
	private QnaService qnaservice;
	@Autowired
	private FaqService faqservice;
	@Autowired
	private QnacommentService qcservice;

	
	static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	
	//notice 전체리스트
	@RequestMapping("noticePage")   
	public void getNoticeList(Model m) {
		Notice vo = new Notice();
		List<Notice> list = notiservice.getNoticeList(vo);
		m.addAttribute("noticeList", list);
	}

	//notice 상세보기
	@RequestMapping("noticePageDetail")
	public void getNotice(Notice vo, Model m) {
		Notice vo1 = notiservice.getNotice(vo);
		m.addAttribute("notice",vo1);
	}
	
	//qna 전체리스트
	@RequestMapping("mypageQna")
	public void getQnaList(HttpServletRequest request,Qna q,Model m) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");		
		List<Qna> list = qnaservice.getQnaList(q);
		List<Qnacomment> list1 = qcservice.selectQcList();
		
			
		for(Qna q1 : list) {
			for(Qnacomment qc : list1) {
				if(q1.getQcode() == qc.getQcode().getQcode()) {
					
					q1.setQnastate("답변완료");
					qnaservice.selectUpdate(q1);
				}
			}
		}		
		
		m.addAttribute("nid", nid);
		m.addAttribute("qList", list);
	}
	
//	//qna 상세보기
//	@RequestMapping("mypageQnaDetail")
//	public void getQnaDetail(HttpServletRequest request,Qna q, Qnacomment qc,Model m) {
//		HttpSession session = request.getSession();
//		System.out.println(qc.getQcode().getQcode());
//		String nid = (String) session.getAttribute("nid");		
//		List<Object[]> list = qnaservice.getQnaDetail(qc.getQcode().getQcode());
//		
//		for(Object[] Obj : list) {
//			if(qc.getCcontent() == null) {
//				Obj.
//				
//			}
//		}
//			
//		
//		m.addAttribute("qna", list);
//		m.addAttribute("nid", nid);
//	}
//	
	
	//qna 상세보기
	@RequestMapping("mypageQnaDetail")
	public void getQnaDetail(HttpServletRequest request,Qna q, Qnacomment qc,Model m) {
		HttpSession session = request.getSession();
		System.out.println(qc.getQcode().getQcode());
		String nid = (String) session.getAttribute("nid");
		
		
		List<Object[]> list = qnaservice.getQnaDetail(qc.getQcode().getQcode());
		m.addAttribute("qna", list);
		m.addAttribute("nid", nid);
		
		
	}
	
//	//qna 상세보기
//	@RequestMapping("mypageQnaDetail")
//	public void getQnaDetail(HttpServletRequest request,Qna q, Qnacomment qc,Model m) {
//		HttpSession session = request.getSession();
//		System.out.println(qc.getQcode().getQcode());
//		String nid = (String) session.getAttribute("nid");
//		
//		List<Qnacomment> qn = (List<Qnacomment>)qcservice.selectQcList();
//		boolean ck = false;
//		
//		for(Qnacomment a : qn) {
//			if(qc.getQcode().getQcode() == a.getQcode().getQcode()) {
//				List<Object[]> list = qnaservice.getQnaDetail(qc.getQcode().getQcode());
//				m.addAttribute("qna", list);
//				m.addAttribute("nid", nid);
//				//m.addAttribute("qList", list);
//				ck=true;
//				break;
//			}
//			
//		}
//		
//		if(ck==false) {
//			List<Qna> inqna = new ArrayList<Qna>();
//			List<Qna> qnack = (List<Qna>)qnaservice.getQnaList(q);
//			
//			for(Qna qnac : qnack) {
//				if(qnac.getQcode() == q.getQcode()) {
//					inqna.add(qnac);
//				}
//			}
//			
//			m.addAttribute("qna", inqna);
//			m.addAttribute("nid", nid);
//		}
//		
//			
//	}
	
//	//qna 상세보기
//	@RequestMapping("mypageQnaDetail")
//	public void getQnaDetail(HttpServletRequest request,Qna q, Qnacomment qc,Model m) {
//		HttpSession session = request.getSession();
//		System.out.println(qc.getQcode().getQcode());
//		String nid = (String) session.getAttribute("nid");		
//		List<Object[]> list = qnaservice.getQnaDetail(qc.getQcode().getQcode());
//		
//		m.addAttribute("qna", list);
//		/*List<Qnacomment> list1 = qcservice.getQcList(qc);			
//		
//		List<qc> list2 = new ArrayList<qc>();
//		
//		for(int i=0; i<list.size(); i++) {
//			for(int j=0; j<list1.size(); j++) {
//				if((list.get(i)).getQcode() == (list1.get(j)).getQcode().getQcode()) {
//					qc a = new qc();
//					a.setCcontent(list1.get(j).getCcontent());
//					a.setNcontent(list.get(i).getNcontent());
//					a.setNdate(list.get(i).getNdate());
//					a.setNid(list.get(i).getNid());
//					a.setNtitle(list.get(i).getNtitle());
//					a.setQcode(list.get(i).getQcode());
//					
//					list2.add(a);
//				}
//			}
//		}
//		*/
//		
//		//m.addAttribute("qnalist",list2);
//		m.addAttribute("nid", nid);
//		m.addAttribute("qList", list);
//		//m.addAttribute("qnacomment", list1);
//	}
	
	
	
	//qna 수정값 가져오기
	@RequestMapping("qnaPageUpdate")
	public void getQnaUpdate(HttpServletRequest request, Qna q,Model m) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		Qna qna1 = qnaservice.getQnaUpdate(q);
		
		m.addAttribute("nid",nid);
		m.addAttribute("qnaPageUpdate", qna1);
	}
	
	//qna 수정하기
	@RequestMapping("qnaUpdate")
	public String qnaUpdate(Qna q) {
		qnaservice.qnaUpdate(q);
		
		return "redirect:mypageQna";
	}
	
	//qna 삭제하기
	@RequestMapping("qnaDelete")
	public String qnaDelete(Qna q) {
		qnaservice.qnaDelete(q);
		
		return "redirect:mypageQna";
	}
	
	//qna insert 로그인 세션
	@RequestMapping("qnaInsert")
	public void loginname(HttpServletRequest request, Model m) {
		logger.info("loginidcheck");
		HttpSession session=request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("nid", nid);
	}
	
	//qna 등록하기
	@RequestMapping("insertQna")
	public String insertQna(HttpServletRequest request, Qna q) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		
		Normalid vo = new Normalid();
		vo.setNid(nid);
		
		q.setNid(vo);
		
		qnaservice.insertQna(q);
		
		
		return "redirect:mypageQna";
	}
	
	//faq 전체 리스트 출력
	@RequestMapping("faqPage")
	public void FaqPageList(HttpServletRequest request, Faq f,Model m) {
		HttpSession session=request.getSession();
		String nid = (String) session.getAttribute("nid");
		List<Faq> list = faqservice.FaqPageList(f);
		
		m.addAttribute("nid", nid);
		m.addAttribute("faqList", list);
		
	}
	
	//faq 상세보기
	@RequestMapping("faqPageDetail")
	public void FaqPageDetail(HttpServletRequest request, Faq f,Model m) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		Faq faq = faqservice.FaqPageDetail(f);
		
		m.addAttribute("nid", nid);
		m.addAttribute("faqDetail", faq);
	}
	
	
}
