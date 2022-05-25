package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Admin1Controller;
import com.example.domain.Normalid;
import com.example.persistence.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
		
	@Autowired
	private CustomerRepository CustomerRepo;
	
	//고객 전체 리스트
	@Override
	public List<Normalid> customerList(Normalid id) {
		logger.info("고객 전체 리스트");	
		return (List<Normalid>)CustomerRepo.findAll();
	}
	
	//고객 상세보기
	@Override
	public Normalid customerdetail(Normalid id) {
		logger.info("고객 상세보기");
		return CustomerRepo.findById(id.getNid()).get();
	}
}
