package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Like {

	@Id
	private Integer likecode;
	private Integer heart;
	
	@OneToOne
	@JoinColumn(name="bcode")
	private Sellerid sellerid;
	
	@OneToOne
	@JoinColumn(name="nid")
	private Normalid normalid;
}
