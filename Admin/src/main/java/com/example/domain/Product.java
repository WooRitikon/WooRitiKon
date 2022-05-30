package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
	
	@Id
	private Integer pcode;
	private Integer bcode;
	private Integer pprice;
	private String pname;
	private String pcategory;
	private String senderid;
	private String giftstate;
	private String pcontent;

}
