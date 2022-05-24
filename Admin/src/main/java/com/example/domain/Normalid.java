package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
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
	private String nsubscribe;
	private String nauthority;
}
