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
	
	
	@Override
	public Normalid idCheck(Normalid vo) {
		Optional<Normalid> result = gifticonRepo.findById(vo.getNid());
		if(result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}
	
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

}
