package com.example.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Integer pcode;
	private Integer pprice;
	private String pname;
	private String pcategory;
	private String pgiftcode;
	private Date pgiftstart;
	private Date pgiftend;
	private String senderid;
	private String giftstate;
	private String pcontent;
	
	@ManyToOne
	@JoinColumn(name="bcode")
	private Sellerid sellerid;

}
