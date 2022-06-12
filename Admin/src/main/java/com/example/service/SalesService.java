package com.example.service;

import java.util.List;

import com.example.domain.Calculate;

public interface SalesService{
	
	List<Calculate> getSalesList(Calculate vo);
	List<Calculate> getSales(Calculate vo);
	
}
