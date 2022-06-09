package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pcode;
	private Integer pprice;
	private String bcode;
	private String pname;
	private String pcategory;
<<<<<<< HEAD
	
	private String shortiamge;
	private String originimage;
	private String pcontent;
	
//	@ManyToOne
//	@JoinColumn(name="bcode")
	private Integer bcode;
=======
	private String pcontent;
	
	private String shotimage;
	private String originimage;
>>>>>>> upstream/main

}
