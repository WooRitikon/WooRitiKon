package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Orderlist {
	@Id
	@GeneratedValue
	private Integer noticecode;
	private String ntitle;
	private String ncategory;
	private String ncontent;
	
	@CreationTimestamp
	private LocalDate ndate;
	
	@JoinColumn(name="mcode")
	private Integer mcode;
}
