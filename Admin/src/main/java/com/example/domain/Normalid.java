package com.example.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="normalid")
public class Normalid {
	
	@Id
	private String nid;
	private String npassword;
	private String nname;
	private String ntel;
	private String nemail;
	private String npostcode;
	private String naddress;
	private String ndaddress;
	private String ngender;
	private String nbirth;
	private Integer ncharge;


	@CreationTimestamp
	private LocalDate nsubscribe;

}
