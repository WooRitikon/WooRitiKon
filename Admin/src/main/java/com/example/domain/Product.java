package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue
	private Integer pcode;
	private Integer pprice;
	private String pname;
	private String pcategory;
	private String senderid;
	private String giftstate;
	private String pcontent;
	private String pimage;
	private String prealimage;
	
	@ManyToOne
	@JoinColumn(name="bcode")
	private Sellerid sellerid;

}
