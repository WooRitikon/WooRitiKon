package com.example.domain;

import java.time.LocalDate;

public class qc {
	
	private Integer qcode;
	private String ntitle;
	private Normalid nid;
	private LocalDate ndate;
	private String ncontent;
	private Integer ccode;
	private String ccontent;
	public Integer getQcode() {
		return qcode;
	}
	public void setQcode(Integer qcode) {
		this.qcode = qcode;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public Normalid getNid() {
		return nid;
	}
	public void setNid(Normalid nid) {
		this.nid = nid;
	}
	public LocalDate getNdate() {
		return ndate;
	}
	public void setNdate(LocalDate ndate) {
		this.ndate = ndate;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Integer getCcode() {
		return ccode;
	}
	public void setCcode(Integer ccode) {
		this.ccode = ccode;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	
	
	
	
	
}
