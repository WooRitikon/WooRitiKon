package com.example.service;

import java.util.List;

import com.example.domain.Category;

public interface CategoryService {
	
	//카테고리 전체 리스트
	List<Category> getCategory(Category cg);
	
	//카테고리 등록
	void insertcg(Category cg);
	
	//카테고리 삭제
	void deletecg(Category cg);
	
}
