package com.example.domain;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name="giftikon")
public class Giftikon {

	@Id
	private Integer gcode;
	private String giftcode;
	private LocalDate startdate;
	
	@ManyToOne
	@JoinColumn(name="nid")
	private Normalid normalid;
	
	@ManyToOne
	@JoinColumn(name="pcode")
	private Product product;

	private LocalDate finaldate;
	private String giftstate;
	private int giftcount;
	
	
}
