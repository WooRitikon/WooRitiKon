package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Normalid;
import com.example.domain.Sellerid;
import com.example.persistence.NormalidRepository;
import com.example.persistence.SellerRepository;

@Service
public class GifticonServiceImpl implements GifticonService {
	
	
	@Autowired
	private NormalidRepository gifticonRepo;
	
	@Autowired
	private SellerRepository sellerRepo;
	
	@Override
	public void savenormalId(Normalid vo) {
		gifticonRepo.save(vo);
	}
	
	public void savesellerId(Sellerid vo) {
		sellerRepo.save(vo);
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
<<<<<<< HEAD
	
	

=======
>>>>>>> upstream/main
}
