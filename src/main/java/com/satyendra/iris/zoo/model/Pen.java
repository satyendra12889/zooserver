package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pen")
public class Pen {
	
	@Id
	public int id;
	
	public String name;
	
	@ManyToOne
	public Zoo zoo;
	
//	@ja
//	@OneToOne
//	public Animal anml;
//	
	

}
