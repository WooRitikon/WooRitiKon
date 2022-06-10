package com.example.domain;

import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
>>>>>>> upstream/main
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orderlist")
public class Orderlist {

	@Id
<<<<<<< HEAD
	private Integer listcode;
	
	@ManyToOne
	@JoinColumn(name="onum")
	private Order order;
	
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer listcode;
	
	@ManyToOne
	@JoinColumn(name ="onum")
	private Order order;
>>>>>>> upstream/main
	private Integer quantity;
	private Integer totalprice;
	
	@ManyToOne
<<<<<<< HEAD
	@JoinColumn(name="pcode")
	private Product product;

=======
	@JoinColumn(name ="pcode")
	private Product product;
	
>>>>>>> upstream/main
	

	
}
