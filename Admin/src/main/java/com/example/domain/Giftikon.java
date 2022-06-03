package com.example.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="giftikon")
public class Giftikon {

	@Id
	private Integer gcode;
	private Integer giftcode;
	private Date startdate;
	
	@ManyToOne
	@JoinColumn(name="nid")
	private Normalid normalid;
	
	@ManyToOne
	@JoinColumn(name="pcode")
	private Product product;
	
	private Date finaldate;
	
}
