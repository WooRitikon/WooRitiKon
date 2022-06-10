package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bucket")
public class Bucket {

	@Id
	private Integer bucketcode;
	private Integer quantity;
	
//	@ManyToOne
//	@JoinColumn(name="nid")
	private String nid;

	
	
//	@ManyToOne
//	@JoinColumn(name="pcode")
	private Integer pcode;
	private Integer btotal;
}
