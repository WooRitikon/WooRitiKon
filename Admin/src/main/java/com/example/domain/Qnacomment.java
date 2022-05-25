package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Qnacomment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ccode;
	private String ccontent;
	@CreationTimestamp
	private LocalDate cdate;
	
	private Integer qcode;
	
}
