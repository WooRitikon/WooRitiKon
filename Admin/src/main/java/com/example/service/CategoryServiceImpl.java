package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.Admin1Controller;
import com.example.domain.Category;
import com.example.persistence.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	static final Logger logger = LoggerFactory.getLogger(Admin1Controller.class);
	
	@Autowired
	private CategoryRepository cgRepo;
	
	//카테고리 전체 가져오기
	@Override
	public List<Category> getCategory(Category cg) {
		logger.info("카테고리 가져오기");
		
		return (List<Category>)cgRepo.findAll();
	}
	
	//카테고리 등록
	@Override
	public void insertcg(Category cg) {
		cgRepo.save(cg);
	}
	
	//카테고리 삭제
	@Override
	public void deletecg(Category cg) {
		cgRepo.delete(cg);
	}
}
