package com.example.service;

import com.example.domain.Normalid;
import com.example.domain.Sellerid;

public interface GifticonService {
	
	public void savenormalId(Normalid vo);
	
	
	public Normalid idCheck(Normalid vo);
	
	
	public Normalid nloginCheck(Normalid vo);
	
	public Sellerid sloginCheck(Sellerid vo);
	

}
