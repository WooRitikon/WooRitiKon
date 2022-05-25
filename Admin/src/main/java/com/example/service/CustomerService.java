package com.example.service;

import java.util.List;

import com.example.domain.Normalid;

public interface CustomerService {

	//고객 전체 리스트
	List<Normalid> customerList(Normalid id);
	
	//고객 상세보기
	Normalid customerdetail(Normalid id);
}
