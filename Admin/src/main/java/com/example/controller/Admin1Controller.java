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
import com.example.domain.Manager;
import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.domain.Qna;
import com.example.domain.Qnacomment;
import com.example.domain.Sellerid;
import com.example.domain.qc;
import com.example.service.CustomerService;
import com.example.service.FaqService;
import com.example.service.ProductService;
import com.example.service.QnaService;
import com.example.service.QnacommentService;
import com.example.service.SellerService;

@Controller
//@RequestMapping("/admin")
public class Admin1Controller {

	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
	
	@Autowired
	private QnaService qnaService;
	@Autowired
	private QnacommentService qnacommentService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private FaqService faqService;

	
	//질문응답 리스트 전체조회
	@RequestMapping("/getQnaList")
	public void getQnaList(Model m) {
		logger.info("전체 QNA");
		Qna vo = new Qna();
		List<Qna> list = qnaService.getQnaList(vo);
		List<Qnacomment> list1 = qnacommentService.selectQcList();
		
		for(Qna q1 : list) {
			for(Qnacomment qc: list1) {
				if(q1.getQcode()==qc.getQcode().getQcode()) {
					
					q1.setQnastate("답변완료");
					qnaService.selectUpdate(q1);
				}
			}
		}
		
		
		m.addAttribute("qnaList", list);
	}
	
	//질문응답 삭제버튼 삭제
	@RequestMapping("/deleteQna")
	public String deleteQna(Qna q) {
		logger.info("qna 삭제");
		qnaService.deleteQna(q);
		
		
		return "redirect:/getQnaList";
		
	}
	// qna 상세보기
	@RequestMapping("getQnaDetail")
	public void getQnaDetail(HttpServletRequest request,Qna q,Model m) {
		HttpSession session = request.getSession();
		String nid = (String) session.getAttribute("nid");
		Qna qna = qnaService.getQnaDetail(q);
		
		m.addAttribute("nid", nid);
		m.addAttribute("qnaDetail", qna);
	}
	
	//qna 수정하기
	@RequestMapping("adminqnaUpdate")
	public String qnaUpdate(Qna q) {
		qnaService.qnaUpdate(q);
		
		return "redirect:getQnaList";
	}
	
	//답글 제목 가져오기
	@RequestMapping("/qnareply")
	public String replyList(Qna q,Model m) {
		
		Qna qc = qnaService.replyList(q);
		logger.info("내용 가져오기:"+qc.getNcontent());
		m.addAttribute("Qna",qc);
		return "/qnareply";
	}
	
	
	//답글 추가
	@RequestMapping("/insertReply")
	public String insertReply(Qnacomment qc) {
		logger.info("답글등록");
		qnacommentService.insertReply(qc);
		
		return "redirect:getQnaList";
	}
	
	//고객 전체 리스트
	@RequestMapping("/customer")
	public void customerList(Model m) {
		logger.info("고객 전체 리스트");
		Normalid id = new Normalid();
		List<Normalid> list = customerService.customerList(id);
		m.addAttribute("normalId", list);
		
	}
	
	//고객 상세 보기
	@RequestMapping("/customerdetail")
	public void customerdetail(Normalid id,Model m) {
		logger.info("고객 상세보기");
		Normalid nidd = customerService.customerdetail(id);
		m.addAttribute("cdetail", nidd);
	
	}
	
	//판매자 전체보기 리스트
	@RequestMapping("/seller")
	public void getSellerList(Model m) {
		logger.info("판매자 전체보기");
		Sellerid sid = new Sellerid();
		List<Sellerid> list = sellerService.getSellerList(sid);
		m.addAttribute("sellerList", list);
		
	}
	
	//판매자 상세보기
	@RequestMapping("/sellerdetail")
	public void sellerdetail(Sellerid sid,Model m) {
		logger.info("판매자 상세보기");
		Sellerid sidd = sellerService.sellerdetail(sid);
		m.addAttribute("sdetail", sidd);
		
	}
	
	//상품 전체리스트
	@RequestMapping("/product")
	public void getProductList(Product pd,Model m) {
		logger.info("전체상품 가져오기");
		List<Product> list = productService.getProductList(pd);
		m.addAttribute("pdList",list);
	}
	
	//상품 삭제
	@RequestMapping("/deleteProduct")
	public String deleteProduct(Product pd) {
		logger.info("상품 삭제");
		productService.deleteProduct(pd);
		
		return "redirect:product";
	
	
	}
	
	//faq 관리자 리스트 출력 
	@RequestMapping("getFaqList")
	public void getFaqList(Faq f, Model m) {
		List<Faq> list = faqService.getFaqList(f);
		
		m.addAttribute("faqList", list);
		
	}
	
	//faq 등록
	@RequestMapping("insertFaq")
	public String insertFaq(HttpServletRequest request, Faq f) {
		HttpSession session = request.getSession();
		Integer mcode = (Integer) session.getAttribute("mcode");
		Manager m = new Manager();
		m.setMcode(mcode);
		
		f.setMcode(m);
		
		faqService.insertFaq(f);
		
		return "redirect:faqPage";
	}
	
	//faq 삭제
	@RequestMapping("deleteFaq")
	public String deleteFaq(Faq f) {
		logger.info("faq 삭제");
		faqService.deleteFaq(f);
		
		return "redirect:getFaqList";
		
		}
	
	//faq 상세보기 페이지
	@RequestMapping("getFaqDetail")
	public void FaqPageDetail(Faq f,Model m) {
		Faq faq=faqService.FaqPageDetail(f);
		
		m.addAttribute("faqDetail", faq);
	}
	
	//faq 수정하기
	@RequestMapping("getFapUpdate")
	public String FaqUpdate(Faq f) {
		faqService.FaqUpdate(f);
		
		return "redirect:getFaqList";
	}
}

