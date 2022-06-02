package com.example.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Normalid;

public interface GifticonService {
	
	public void savenormalId(Normalid vo);
	
	
	public Normalid idCheck(Normalid vo);
	
	
	public Normalid nloginCheck(Normalid vo);
	
	

}
