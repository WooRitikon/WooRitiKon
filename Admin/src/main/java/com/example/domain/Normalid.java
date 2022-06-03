package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate()")
	@Temporal(TemporalType.DATE)
	private Date nsubscribe;
	private String nauthority;
}
