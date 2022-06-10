package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Normalid;
import com.example.domain.Product;
import com.example.domain.Sellerid;
import com.example.persistence.NormalidRepository;
import com.example.persistence.ProductRepository;
import com.example.persistence.SellerRepository;

@Service
public class GifticonServiceImpl implements GifticonService {
	
	
	@Autowired
	private NormalidRepository gifticonRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	@Override
	public void savenormalId(Normalid vo) {
		gifticonRepo.save(vo);
	}
	
	public void savesellerId(Sellerid vo) {
		sellerRepo.save(vo);
	}
	
	//판매자 아이디 모두 불러오기
	@Override
	public List<Sellerid> allseller(){
		List<Sellerid> result = (List<Sellerid>)sellerRepo.findAll();
		
		return result;
	}
	
	@Override
	public Normalid idCheck(Normalid vo) {
		Optional<Normalid> result = gifticonRepo.findById(vo.getNid());
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
	
	//판매자 아이디 중복체크
	@Override
	public Sellerid sellerCheck(Sellerid vo) {
		
		List<Sellerid> result = (List<Sellerid>)sellerRepo.findAll();
		
		for(Sellerid sidck: result) {
			if((sidck.getSid()).equals(vo.getSid())) {
				System.out.println("출력아이디:"+sidck.getSid());
				return sidck;
			}
		}
		return null;
	}
	
	//상품테이블 3개 출력(완료)
	@Override
	public List<Product> selectproduct() {
		
		//모든 상품리스트 출력
		List<Product> result = (List<Product>)proRepo.findAll();
		List<Product> last= new ArrayList<Product>();
		
		int length = result.size();
		int start = 1;
		int end = length-3;
		
		last.add(result.get(length-1));
		last.add(result.get(length-2));
		last.add(result.get(length-3));
		
		return last;
	}
	
	//HOT DEL 3개 출력
	@Override
	public List<Product> selectHot() {

		//모든 상품리스트 출력
		List<Product> result = (List<Product>)proRepo.findAll();
		List<Product> last= new ArrayList<Product>();

		int length = result.size();
		int random= length+1;
		int arrcheck[] = new int[3];
		int check=0;

		for(int i=0; i<3; i++) {
			while(length <random) {
				random = (int)((Math.random()*length)+1);

				for(int j=0; j<3; j++) {
					
					if(arrcheck[j] != random) {
						check++;
					}
					
					if((length>random) && (check==3)) {
						last.add(result.get(random));
						arrcheck[i]=random;
					}else if(check==3) {
						random = length+1;
					}
				}
				
				check=0;
			}
			
			random = length+1;
		}

		return last;
	}
	
	//판매자 리스트 3개 출력(완료)
	@Override
	public List<Sellerid> selectSeller() {
		
		//모든 판매자리스트 출력
		List<Sellerid> result = (List<Sellerid>)sellerRepo.findAll();
		List<Sellerid> last= new ArrayList<Sellerid>();
		
		int length = result.size();
		int start = 1;
		int end = length-3;
		
		last.add(result.get(length-1));
		last.add(result.get(length-2));
		last.add(result.get(length-3));
		
		return last;
	}
	
	//판매자회원 아이디 찾기
	public Sellerid detectsid(Sellerid vo) {
		List<Sellerid> dck = (List<Sellerid>)sellerRepo.findAll();
		
		for(Sellerid idck: dck) {
			if(idck.getSname().equals(vo.getSname()) && idck.getStel().equals(vo.getStel()) 
					&& idck.getSbirth().equals(vo.getSbirth()) && idck.getBcode().equals(vo.getBcode())) {
				return idck;
			}
		}
		return null;
	}
	
	//판매자회원 비밀번호 찾기
	public Sellerid detectspass(Sellerid vo) {
		List<Sellerid> dck = (List<Sellerid>)sellerRepo.findAll();
		
		for(Sellerid idck: dck) {
			if(idck.getSname().equals(vo.getSname()) && idck.getStel().equals(vo.getStel()) 
					&& idck.getSbirth().equals(vo.getSbirth()) && idck.getBcode().equals(vo.getBcode())
					&& idck.getSid().equals(vo.getSid())) {
				return idck;
			}
		}
		return null;
	}
	
	//일반회원 로그인
	@Override
	public Normalid nloginCheck(Normalid vo) {
		List<Normalid> ck = (List<Normalid>) gifticonRepo.findAll();
		
		for(Normalid idck: ck) {
			if(idck.getNid().equals(vo.getNid()) && idck.getNpassword().equals(vo.getNpassword())) {
				return idck;
			}
		}
		return null;
	}
	
	//일반회원 아이디 찾기
	@Override
	public Normalid detectnid(Normalid vo) {
		List<Normalid> dck = (List<Normalid>) gifticonRepo.findAll();
		
		for(Normalid idck: dck) {
			if(idck.getNname().equals(vo.getNname()) && idck.getNtel().equals(vo.getNtel()) && idck.getNbirth().equals(vo.getNbirth())) {
				return idck;
			}
		}
		
		return null;
	}
	
	//일반회원 비밀번호 찾기
	@Override
	public Normalid detectnpass(Normalid vo) {
		List<Normalid> dck = (List<Normalid>) gifticonRepo.findAll();
		
		for(Normalid idck: dck) {
			if(idck.getNname().equals(vo.getNname()) && idck.getNtel().equals(vo.getNtel()) 
					&& idck.getNbirth().equals(vo.getNbirth()) && idck.getNid().equals(vo.getNid())) {
				return idck;
			}
		}
		
		return null;
	}
	
	//판매자 로그인 유효성검사
	@Override
	public Sellerid sloginCheck(Sellerid vo) {
		
		List<Sellerid> ck = (List<Sellerid>) sellerRepo.findAll();
		
		for(Sellerid idck: ck) {
			if(idck.getSid().equals(vo.getSid()) && idck.getSpassword().equals(vo.getSpassword())) {
				return idck;
			}
		}
		
		return null;
	}


	//판매자 가게 정보 검색
	@Override
	public List<Sellerid> searchseller(Sellerid vo){
	
		List<Sellerid> ck = (List<Sellerid>) sellerRepo.findAll();
		List<Sellerid> last= new ArrayList<Sellerid>();
		
		for(Sellerid idck: ck) {
			if(idck.getCcode() == vo.getCcode()) {
				last.add(idck);
			}
		}
		
		return last;
	}

}
