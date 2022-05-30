package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Manager {
	@Id
	@Column(name="mcode")
	private Integer mcode;
	private String mid;
	private String mpassword;
}
