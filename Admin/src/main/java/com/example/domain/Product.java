package com.example.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	private Integer pcode;
	private String bcode;
	private Integer pprice;
	private String pname;
	private String pcategory;
	private String pgiftcode;
	private Date pgiftstart;
	private Date pgiftend;
	private String senderid;
	private String giftstate;
	private String pcontent;

}
