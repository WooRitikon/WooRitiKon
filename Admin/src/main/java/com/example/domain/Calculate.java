package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Data
@Entity
public class Calculate {
	@Id
	@GeneratedValue
	private Integer calcode;
	private Integer onum;
	private String bcode;
	private Integer scalprice;
	private Integer fee;
	private String caldate;
	private Integer listcode;
}
