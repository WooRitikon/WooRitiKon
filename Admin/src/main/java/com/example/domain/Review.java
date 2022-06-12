package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

//리뷰
@Data
@Entity
public class Review {

	//리뷰번호
	@Id
	@GeneratedValue
	private Integer rcode;
	//상품코드
	private String bcode;
	//내용
	private String rcontent;
	//작성 날짜
	private String writedate;
	//별점
	private Integer star; 
	//사용자아이디
	private String nid; 
}
