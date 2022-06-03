package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bucket")
public class Bucket {

	@Id
	private Integer bcode;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name="nid")
	private Normalid normalid;
	
	@ManyToOne
	@JoinColumn(name="pcode")
	private Product prouduct;
}
