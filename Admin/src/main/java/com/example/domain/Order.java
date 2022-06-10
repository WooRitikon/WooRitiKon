package com.example.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order")
public class Order {
	
	@Id
	private Integer onum;
	
	private Date odate;
	private String oselect;
	private Integer otatal;
	private String ostate;
	
	@ManyToOne
	@JoinColumn(name="nid")
	private Normalid normalid;
	

}
