package com.example.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Bucket;
import com.example.domain.Buy;
import com.example.domain.Giftikon;
import com.example.domain.Like;
import com.example.domain.Normalid;
import com.example.domain.Orderlist;

import com.example.domain.Product;
import com.example.domain.Tbucket;
import com.example.persistence.BucketRepository;
import com.example.persistence.GiftikonRepository;
import com.example.persistence.LikeRepository;
import com.example.persistence.MypageMainRepository;
import com.example.persistence.ProductRepository;
import com.example.service.GifticonService;
import com.example.service.MypageService;





@Controller
public class MypageController {

	static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	@Autowired
	private GiftikonRepository giftikonRepo;
	
	@Autowired
	private MypageService mypageService;

	@Autowired
	private LikeRepository likeRepo;
	
	@Autowired
	private GifticonService gifticonService;
	
	@Autowired
	private MypageMainRepository mypageMainRepo;
	
	
	@Autowired
	private ProductRepository ProRepo;
	
	@Autowired
	private BucketRepository BucketRepo;

	//이름 가져오기
	@RequestMapping("/mypageMain")
	public void getname(HttpServletRequest request, Model m) {
		logger.info("getname controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("nid", mypageService.getname(nid));
	}
	
	//결제정보
	@RequestMapping("/payment")
	public void payment(Model m, HttpServletRequest request) {
		logger.info("payment controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("buy", mypageService.selectOrderNum(nid));
		m.addAttribute("nid", mypageService.getNid(nid));
	}
	
	//결제정보
		@RequestMapping("/payment_sucess")
		public void payment_success(Model m, HttpServletRequest request) {
			logger.info("payment_success controller");
			HttpSession session = request.getSession();
			String nid = (String)session.getAttribute("nid");
			
			m.addAttribute("buy", mypageService.selectOrderNum(nid));
			m.addAttribute("nid", mypageService.getNid(nid));
		}
	
		//결제정보
		@RequestMapping("/payment_fail")
		public void payment_fail(Model m, HttpServletRequest request) {
			logger.info("payment_success controller");
			HttpSession session = request.getSession();
			String nid = (String)session.getAttribute("nid");
			
			m.addAttribute("buy", mypageService.selectOrderNum(nid));
			m.addAttribute("nid", mypageService.getNid(nid));
		}
	
	//<주문조회>
	//기프티콘리스트출력

	@RequestMapping("/mypageShoppingList")
	public void getGiftList(Model m, HttpServletRequest request) {
		logger.info("getGiftList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<HashMap<String, Object>> giftSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftSelect(nid);
		for(Object[] giftobj : gift) {
			HashMap<String, Object> gift1 = new HashMap<String, Object>();
			gift1.put("NID", giftobj[0]);
			gift1.put("STARTDATE", giftobj[1]);
			gift1.put("FINALDATE", giftobj[2]);
			gift1.put("PCODE", giftobj[3]);
			gift1.put("PPRICE", giftobj[4]);
			gift1.put("PCATEGORY", giftobj[5]);
			gift1.put("PNAME", giftobj[6]);
			gift1.put("PCONTENT", giftobj[7]);
			gift1.put("GCODE", giftobj[8]);
			
			giftSelect.add(gift1);
		}
		m.addAttribute("giftikon", giftSelect);
		m.addAttribute("nid", nid);
	
	}
	
	//기프티콘 상세보기
	@RequestMapping("/mypageShoppingSet")
	public void getGiftikonSet(HttpServletRequest request, Giftikon gi, Model m) {
		logger.info("getGiftikontSet controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		Giftikon g = mypageService.getGiftikonSet(gi);
		System.out.println(g);
		session.setAttribute("giftikon",g);
		m.addAttribute("giftikon", g);
		m.addAttribute("product", g.getProduct());
		m.addAttribute("normalid", g.getNormalid());
		
	}
	
	//<바코드구현>
	@RequestMapping("/mypageQRCode")
	public void mypageQRCode(HttpServletRequest request,Model m) {
		logger.info("mypageQRCode controller");
		HttpSession session = request.getSession();
		Giftikon g =(Giftikon)session.getAttribute("giftikon");
		m.addAttribute("giftikon", g.getGiftcode());
	}
	
	// 구매내역보기
	@RequestMapping("/mypageShoppingAllList")
	public void getGiftAllList(HttpServletRequest request, Model m) {
		logger.info("getGiftList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		List<HashMap<String, Object>> giftSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftAllSelect(nid);
		for(Object[] giftobj : gift) {
			HashMap<String, Object> gift1 = new HashMap<String, Object>();
			gift1.put("NID", giftobj[0]);
			gift1.put("STARTDATE", giftobj[1]);
			gift1.put("FINALDATE", giftobj[2]);
			gift1.put("PCODE", giftobj[3]);
			gift1.put("PPRICE", giftobj[4]);
			gift1.put("PCATEGORY", giftobj[5]);
			gift1.put("PNAME", giftobj[6]);
			gift1.put("PCONTENT", giftobj[7]);
			gift1.put("GCODE", giftobj[8]);
			
			giftSelect.add(gift1);
		}
		m.addAttribute("giftikon", giftSelect);
		m.addAttribute("nid",nid);
	}

	// <포인트조회>
	// 포인트 조회하기
	 @RequestMapping("/mypagePointSet") 
	 public void getPointSet(HttpServletRequest request, Model m) { 
		 logger.info("getPointSet controller");
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		 
		 m.addAttribute("normalid", mypageService.getPointSet(nid)); 
		 }
	 
	//포인트 결제 페이지
	 @RequestMapping("/mypagePointPlus")
	 public @ResponseBody void mypagePointPlus(HttpServletRequest request,  Model m, Long amount) {
		 logger.info("mypagePointPlus controller");
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		
		 System.out.println(amount);
		 m.addAttribute("nid",nid);
	 }
	 
	 
	// 장바구니조회
	  @RequestMapping("/mypageBasketList")
	  public void createOrder(HttpServletRequest request, Model m){
		  logger.info("장바구니 출력");
		  HttpSession session = request.getSession();
		  String nid = (String)session.getAttribute("nid");
		  
		  List<Product> pr = (List<Product>)ProRepo.findAll();
		  List<Product> Newpr = new ArrayList<Product>();
		  
		  List<Bucket> bu = (List<Bucket>)BucketRepo.findAll();
		  List<Bucket> Newbu = new ArrayList<Bucket>();
		 
		  List<Tbucket> listtb=new ArrayList<Tbucket>();
		  
		  int sum=0;
		  
		  
		  for(Bucket b : bu) {
			  if(b.getNid().equals(nid)) {
				  Newbu.add(b);
			  }
		  }
		  
		  for(Bucket b: Newbu) {
			  for(Product p: pr) {
				  if(b.getPcode() == p.getPcode()) {
					  Newpr.add(p);
					  
					  Tbucket tb = new Tbucket();
					  tb.setPname(p.getPname());
					  tb.setPprice(p.getPprice());
					  tb.setPcode(p.getPcode());
					  tb.setQuantity(b.getQuantity());
					  tb.setTotal(((int)b.getQuantity() *(int)p.getPprice()));
					  
					  listtb.add(tb);
					  
					  //b.setBtotal(b.getQuantity() *p.getPprice());
					  
					  sum += (b.getQuantity() *p.getPprice());
				  }
			  }
		  }
		  
		  m.addAttribute("tb", listtb);
		  m.addAttribute("bucket", Newbu );
		  m.addAttribute("sum", sum);
		  m.addAttribute("product",Newpr);
		  m.addAttribute("nid", nid);
	  }

	
	//mypageplus
	@RequestMapping(value = "/mypagePlus", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String mypagePlus(HttpServletRequest request, String pname) {
		logger.info("플러스 갯수 변경");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		int pprice =0;
		int pcode =0;
		int sum=0;
		
		List<Product> pr = (List<Product>)ProRepo.findAll();
		List<Bucket> bu = (List<Bucket>)BucketRepo.findAll();
		Bucket newbu = new Bucket();
		
		
		for(Product p : pr) {
			if(p.getPname().equals(pname)) {
				pprice = p.getPprice();
				pcode= p.getPcode();
			}
		}
		
		for(Bucket b : bu) {
			if((b.getNid().equals(nid)) && (b.getPcode() == pcode)) {
				newbu.setNid(b.getNid());
				newbu.setPcode(b.getPcode());
				newbu.setBucketcode(b.getBucketcode());
				newbu.setBtotal((b.getBtotal()+pprice));
				newbu.setQuantity((b.getQuantity()+1));
				
				break;
			}
		}
		
		BucketRepo.save(newbu);
		
		//새롭게 정의된 장바구니 리스트 불러오기
		List<Bucket> total = (List<Bucket>)BucketRepo.findAll();
				
		for(Bucket t : total) {
			sum += t.getBtotal();
		}
		
				
		return String.valueOf(sum);
	}
	
	//mypageminus
	@RequestMapping(value = "/mypageMinus", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String mypageMinus(HttpServletRequest request, String pname) {
		logger.info(pname);
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		int pprice =0;
		int pcode =0;
		int sum=0;
		
		
		List<Product> pr = (List<Product>)ProRepo.findAll();
		List<Bucket> bu = (List<Bucket>)BucketRepo.findAll();
		Bucket newbu = new Bucket();
		
		
		for(Product p : pr) {
			if(p.getPname().equals(pname)) {
				pprice = p.getPprice();
				pcode= p.getPcode();
			}
		}
		
		for(Bucket b : bu) {
			if((b.getNid().equals(nid)) && (b.getPcode() == pcode) && (b.getQuantity() > 0)) {
				newbu.setNid(b.getNid());
				newbu.setPcode(b.getPcode());
				newbu.setBucketcode(b.getBucketcode());
				newbu.setBtotal((b.getBtotal()-pprice));
				newbu.setQuantity((b.getQuantity()-1));
				
				break;
			}
		}
		
		BucketRepo.save(newbu);
		
		//새롭게 정의된 장바구니 리스트 불러오기
		List<Bucket> total = (List<Bucket>)BucketRepo.findAll();
		
		for(Bucket t : total) {
			sum += t.getBtotal();
		}
				
		return String.valueOf(sum);
	}
	
	//장바구니 목록 삭제
	@RequestMapping(value = "/bucketDelete", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String bucketDelete(HttpServletRequest request, String pname) {
		logger.info("장바구니 목록 삭제");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		int pcode =0;
		int sum=0;
		
		List<Product> pr = (List<Product>)ProRepo.findAll();
		List<Bucket> bu = (List<Bucket>)BucketRepo.findAll();
		Bucket newbu = new Bucket();
		
		
		for(Product p : pr) {
			if(p.getPname().equals(pname)) {
				pcode= p.getPcode();
			}
		}
		
		for(Bucket b : bu) {
			if((b.getNid().equals(nid)) && (b.getPcode() == pcode)) {
				mypageService.deletebucket(b);
				
				break;
			}
		}
		
		//BucketRepo.delete(newbu);
		
		//새롭게 정의된 장바구니 리스트 불러오기
		List<Bucket> total = (List<Bucket>)BucketRepo.findAll();
				
		for(Bucket t : total) {
			sum += t.getBtotal();
		}
		
				
		//return String.valueOf(sum);
		return String.valueOf(sum);
	}
	
//	//결제페이지 총금액 DB 보내기
//	@RequestMapping(value = "/busketTotal", produces = "application/text;charset=utf-8")
//	@ResponseBody
//	public void busketTotal(HttpServletRequest request, String ototal) {
//		logger.info("플러스 갯수 변경");
//		HttpSession session = request.getSession();
//		String nid = (String)session.getAttribute("nid");
//		
//		
//		
//		BucketRepo.save(newbu);
//	}
//	
	//장바구니 결제 페이지 이동
	@RequestMapping("/mypageBuy")
	public void mypageBuy(HttpServletRequest request, Model m) {
		

		logger.info("mypageBuy controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		  List<Product> pr = (List<Product>)ProRepo.findAll();
		  List<Product> Newpr = new ArrayList<Product>();
		  
		  List<Bucket> bu = (List<Bucket>)BucketRepo.findAll();
		  List<Bucket> Newbu = new ArrayList<Bucket>();
		 
		  List<Tbucket> listtb=new ArrayList<Tbucket>();
		  
		  int sum=0;
		  
		  
		  for(Bucket b : bu) {
			  if(b.getNid().equals(nid)) {
				  Newbu.add(b);
			  }
		  }
		  
		  for(Bucket b: Newbu) {
			  for(Product p: pr) {
				  if(b.getPcode() == p.getPcode()) {
					  Newpr.add(p);
					  
					  Tbucket tb = new Tbucket();
					  tb.setPname(p.getPname());
					  tb.setPprice(p.getPprice());
					  tb.setPcode(p.getPcode());
					  tb.setQuantity(b.getQuantity());
					  tb.setTotal(((int)b.getQuantity() *(int)p.getPprice()));
					  
					  listtb.add(tb);
					  
					  //b.setBtotal(b.getQuantity() *p.getPprice());
					  
					  sum += (b.getQuantity() *p.getPprice());
				  }
			  }
		  }
		  
		  //구매리스트 받아 오기
		  mypageService.buylistget();  
		  
		  //주문정보 생성
		  mypageService.updateOrder(nid);
		  
		  //주문정보 받아 오기
		  mypageService.Orderget();
		  
		//주문번호에 맞는 주문정보 가져오기
		  Buy on = mypageService.selectOrderNum(nid);
		  int onum = on.getOnum();
		  on.setOtotal(sum);
		  
		  mypageService.Ordersave(on);
		  
		  //장바구니 상품 리스트 가져오기(bu)
		  
		  for(Bucket b : Newbu) {
			  mypageService.updateBuylistNumber();
		  }
		  
		  List<Orderlist> ol = mypageService.buylistget();
		  
		  for(Bucket c : Newbu) {
			 for(Orderlist a : ol) {
				 if(a.getPcode() == null) {
					 Orderlist newo=new Orderlist();
					 newo.setListcode(a.getListcode());
					 newo.setOnum(onum);
					 newo.setPcode(c.getPcode());
					 newo.setQuantity(c.getQuantity());
					 newo.setTotalprice(c.getBtotal());
					 
					 mypageService.orderlistsave(newo);
					 break;
				 }
			 }
		  }
		  
		  

		  m.addAttribute("tb", listtb);
		  m.addAttribute("bucket", Newbu );
		  m.addAttribute("sum", sum);
		  m.addAttribute("product",Newpr);
		  m.addAttribute("nid", mypageService.getNid(nid));
		  m.addAttribute("n",nid);
	}
		


	// 찜한가게
	@RequestMapping("/mypageHeartList")
	public void getHeartList(HttpServletRequest request, Model m) {
		logger.info("getHeartList controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		List<HashMap<String, Object>> shopHeart = new ArrayList<HashMap<String, Object>>();
		List<Object[]> shop = likeRepo.shopHeart(nid);
		for(Object[] shopobj : shop) {
			HashMap<String, Object> shop1 = new HashMap<String, Object>();
			shop1.put("NID", shopobj[0]);
			shop1.put("BNAME", shopobj[1]);
			shop1.put("BTEL", shopobj[2]);
			shop1.put("HEART", shopobj[3]);
			
			shopHeart.add(shop1);
		}
		m.addAttribute("shopHeart", shopHeart);
		m.addAttribute("nid",nid);
	}
	
	//찜한 가게 취소 
	@RequestMapping("/cancelHeart")
	public String shopHeartCancel(Like li, HttpServletRequest request) {
		logger.info("shopHeartCancel controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		mypageService.deleteHeart(li);
		return "redirect:mypageHeartList";
	}
	

	// <선물함>
	// 받은 선물함
	@RequestMapping("/mypageGetGift")
	public void getGift(Model m, HttpServletRequest request) {
		logger.info("getGift controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		List<HashMap<String, Object>> giftToSelect = new ArrayList<HashMap<String, Object>>();
		List<Object[]> gift = giftikonRepo.giftToSelect(nid);
		for(Object[] giftobj : gift) {
			HashMap<String, Object> gift1 = new HashMap<String, Object>();
			gift1.put("NID", giftobj[0]);
			gift1.put("STARTDATE", giftobj[1]);
			gift1.put("FINALDATE", giftobj[2]);
			gift1.put("PCODE", giftobj[3]);
			gift1.put("PPRICE", giftobj[4]);
			gift1.put("PCATEGORY", giftobj[5]);
			gift1.put("PNAME", giftobj[6]);
			gift1.put("PCONTENT", giftobj[7]);
			gift1.put("GCODE", giftobj[8]);
			gift1.put("GIFTSTATE", giftobj[9]);
			gift1.put("SENDERID", giftobj[10]);
			
			giftToSelect.add(gift1);
		}
		
		m.addAttribute("giftikon", giftToSelect);
		m.addAttribute("nid",nid);

	}

	// 보낸 선물함
	@RequestMapping("/mypageSendGift")
	public void sendGift() {
		logger.info("sendGift controller");
	}

	// <회원 정보>
	// 회원 정보 조회
	@RequestMapping("/mypageInfo")
	public void getInfo(HttpServletRequest request, Model m) {
		logger.info("getInfo controller");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");
		
		m.addAttribute("nid",nid);
		m.addAttribute("normalid", mypageService.getNid(nid));
	}

	
	  // 회원 정보 수정하기 창 열기
	  @RequestMapping("/mypageInfoUpload")
	  public void infoUpload(HttpServletRequest request, Model m) { 
		  logger.info("infoUpload controller");
		  HttpSession session = request.getSession();
		  String nid = (String)session.getAttribute("nid");
		   
		  m.addAttribute("nid", nid);
		  m.addAttribute("normalid",mypageService.getNid(nid)); 
	}

	
	  //회원 정보 수정
	 @RequestMapping("/mypageInfoUpdate")
	 public String infoUpdate(HttpServletRequest request, Normalid no, Model m) {
		 logger.info("infoUpdate controller"); 
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		  
		 mypageService.getNidUpdate(no);
		 
		 return "/mypageInfo";
	 }
	 

	// 비밀번호 변경 확인
	@RequestMapping("/mypageInfoPass")
	public void infoPass(HttpServletRequest request, Model m) {
		logger.info("비밀번호 유효성검사 페이지");
		HttpSession session = request.getSession();
		String nid = (String)session.getAttribute("nid");

		Normalid result = mypageService.getNid(nid);
		
		m.addAttribute("result",result);
		m.addAttribute("nid",nid);
	}
	
	// 비밀번호 변경 확인
	@RequestMapping("/mypageInfoPassCheck")
	public String infoPass(HttpServletRequest request, Normalid vo, Model m) {
		logger.info("infoPass controller");
		
		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");

		 vo.setNid(nid);
		
		 Normalid result = gifticonService.nloginCheck(vo);
		
		 
		 if (result == null) {
			 session.setAttribute("nid", nid);
			return "redirect:mypageInfoPass";
		} else {
			 m.addAttribute("nid",result);
			return "redirect:mypageInfoPassCommit";
		}

	}

	
	  // 비밀번호 변경하기
	 @RequestMapping("/mypageInfoPassCommit")
	 public void infoPassCommit(HttpServletRequest request, Model m) {
		 logger.info("infoPassCommit controller"); 
		 HttpSession session = request.getSession(); 
		 String nid = (String)session.getAttribute("nid");
		 
		 Normalid result = mypageService.getNid(nid);
		 m.addAttribute("n",nid);
		 m.addAttribute("nid",result);
		
	 }
	 
	 // 비밀번호 변경 업데이트
	 @RequestMapping("/updatePassword")
	 public String updatePassword(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		
		 Normalid result = mypageService.getNid(nid);
		 
		
		 if (result == null) {
			 session.setAttribute("nid", nid);
			 return "redirect:mypageInfopassCommit";
		 } else {
			 result.setNpassword(vo.getNpassword());
			 gifticonService.savenormalId(result);
			 session.invalidate();
			 return "redirect:login";
		 }


	 }
	 
	 //회원 페이지 넘기기
	 @RequestMapping("/mypageInfoCancel")
	 public void mypageInfoCancel(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

			HttpSession session = request.getSession();
			String nid = (String)session.getAttribute("nid");

			Normalid result = mypageService.getNid(nid);
			
			m.addAttribute("nid",result);
			m.addAttribute("n", nid);



	 }
	 
	 //회원탈퇴
	 @RequestMapping("/updateState")
	 public String deleteNormalid(HttpServletRequest request, Normalid vo, Model m) {
		 logger.info("updatePassword controller");

		 HttpSession session = request.getSession();
		 String nid = (String)session.getAttribute("nid");
		
		 Normalid result = mypageService.getNid(nid);
		 
		
		 if (result == null) {
			 session.setAttribute("nid", nid);
			 return "redirect:mypageInfoCancel";
		 } else {
			 result.setNpassword(vo.getNpassword());
			 mypageMainRepo.deleteNormalid(nid);
			 session.invalidate();
			 return "redirect:login";
		 }


	 }

}
