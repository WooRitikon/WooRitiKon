package com.example.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.controller.MypageController;
import com.example.domain.Giftikon;
import com.example.domain.Like;
import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.persistence.GiftikonRepository;
import com.example.persistence.LikeRepository;
import com.example.persistence.MypageMainRepository;
import com.example.persistence.MypageProductRepository;


@Service
public class MypageServiceimpl implements MypageService{
	static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	@Autowired
	private GiftikonRepository giftikonRepo;
	
	@Autowired
	private LikeRepository likeRepo;
	

	
	//<마이페이지 메인>
	//이름가져오기 
	@Override
	public Normalid getname(String nid) {
		logger.info("getnid service");
		return mypageMainRepo.findById(nid).get();
	}
	
	//<주문조회>


	//기프티콘 상세조회
	@Override
	public Giftikon getGiftikonSet(Giftikon gi) {
		return giftikonRepo.findById(gi.getGcode()).get();
	}
	
	

	
	
	//<포인트 조회>
	//포인트 금액 조회
	@Override
	public Normalid getPointSet(String nid) {
		return mypageMainRepo.findById(nid).get();
	}
	
	//<위시리스트>
	//찜한 가게 삭제
	@Override
	public void deleteHeart(Like li) {
		likeRepo.delete(li);
	}
	
//	//장바구니 구현
//	@Override
//	public void createOrder(Normalid no) {
//		Order order = Order.createOrder(no);
//		orderRepo.save(order);
//		
//	}
//	
//	//장바구니에 product 추가
//	@Override
//	@Transactional
//	public void addCart(Normalid normalid, Product product, Integer quantity) {
//	
//		Order order = orderRepo.findByNid(normalid.getNid());
//		
//		//order 가 비었다면 생성
//		if(order == null) {
//			order = order.createOrder(normalid);
//			orderRepo.save(order);
//			
//		}
//		
//		//orderlist 생성
//		Orderlist orderlist = orderlistRepo.findByOnumAndPcode(order.getOnum(), product.getPcode());
//		
//		//orderlist가 비었다면 새로 생성
//		if(orderlist == null) {
//			orderlist = Orderlist.createOrderlist(order, product, quantity);
//			orderlistRepo.save(orderlist);
//			order.setOcount(order.getOcount()+1);
//		}else {
//			orderlist.addQuantity(quantity);
//		}
//	}
//	
//	//장바구니 조회
//	@Override
//	public List<Orderlist> userOrderView(Order order){
//		
//		List<Orderlist> orderlists = orderlistRepo.findAll();
//		List<Orderlist> norderlists = new ArrayList<>();
//		
//		for(Orderlist orderlist : orderlists) {
//			if(orderlist.getOrder().getNormalid() == order.getNormalid()) {
//				norderlists.add(orderlist);
//			}
//		}
//		
//		return norderlists;
//	}
//	
//	//장바구니 product 삭제
//	@Override
//	public void orderProductDelete(Integer onum) {
//		orderlistRepo.deleteById(onum);
//	}
//	
//	//장바구니 결제
//	@Transactional
//	@Override
//	public void orderPayment(String nid) {
//		List<Orderlist> orderlists = orderlistRepo.findAll(); //전제 orderlist 찾기
//		List<Orderlist> norderlists = new ArrayList<>();
//		Normalid buyer = mypageMainRepo.findById(nid).get();
//		
//		//반복문을 이용하여 접속 유저의 orderlist 만 찾아서 저장
//		for(Orderlist orderlist: orderlists) {
//			if(orderlist.getOrder().getNormalid().getNid() == buyer.getNid()) {
//				norderlists.add(orderlist);
//			}
//		}
//		
//		//반복문을 이용하여 접속 유저의 orderlist 만 찾아서 삭제
//		for(Orderlist orderlist : norderlists) {
//			//금액 처리
//			Normalid seller = orderlist.getOrder().getNormalid();
//			int cash = orderlist.getProduct().getPprice();
//			
//			buyer.setNcharge(cash * -1);
//			seller.setNcharge(cash);
//		}
// 	}
//	
	
	//<회원정보 관리>
	//회원정보 조회
	@Override
	public Normalid getNid(String no) {
		return mypageMainRepo.findById(no).get();
	}
	
	
	  //회원정보 수정하기 페이지 넘기기
	  
	  @Override
	  public Normalid infoUpload(Normalid no) { 
		  return mypageMainRepo.findById(no.getNid()).get(); 
	  }
	 
	
	 //회원정보 수정
	  
	 @Override 
	 public void getNidUpdate(Normalid no) { 
		 Normalid no1 = mypageMainRepo.findById(no.getNid()).get(); 
		 
		 no1.setNid(no.getNid());
		 no1.setNtel(no.getNtel());
		 no1.setNemail(no.getNemail()); 
		 no1.setNpostcode(no.getNpostcode());
		 no1.setNaddress(no.getNaddress()); 
		 no1.setNdaddress(no.getNdaddress());
	 
		 mypageMainRepo.save(no1);
	 }
	 
	 
	 

	

	 
}
