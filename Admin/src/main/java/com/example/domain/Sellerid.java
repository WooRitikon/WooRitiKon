package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Sellerid {

	@Id
	@GeneratedValue
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
	
	
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate()")
	@Temporal(TemporalType.DATE)
	private Date ssubscribe;
	
}
