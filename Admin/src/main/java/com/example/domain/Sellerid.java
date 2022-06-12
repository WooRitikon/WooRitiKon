package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Sellerid {

	@Id
	private String bcode;
	private Integer ccode;
	private String sid;
	private String sname;
	private String spassword;
	private String stel;
	private String btel;
	private String semail;
	private String spostcode;
	private String saddress;
	private String sdaddress;
	private String sbirth;
	private String bname;
	private String scontent;
	
	
	@CreationTimestamp
	private LocalDate ssubscribe;
	
	private String shotimage;
	private String originimage;
	
}
