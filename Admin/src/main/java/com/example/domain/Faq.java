package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Faq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fcode;
	private String ftitle;
	private String fcontent;
	@CreationTimestamp
	private LocalDate fdate;
	private String ftype;
	
	@ManyToOne
	@JoinColumn(name="mcode")
	private Manager mcode;

}
