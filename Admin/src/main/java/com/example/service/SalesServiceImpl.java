package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Calculate;
import com.example.persistence.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService{
	
	@Autowired
	private SalesRepository salesRepo;
	
	@Override //매출전체조회
	public List<Calculate> getSalesList(Calculate vo){
		return (List<Calculate>)salesRepo.findAll();
	}
	
	@Override
	public List<Calculate> getSales(Calculate vo){
		return (List<Calculate>)salesRepo.findAll();
	}
	
}
