package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Animal {
	
	@Id
	public int id;
	
	public String name; 
	
	@JsonBackReference
	@ManyToOne
	public AnimalType type;
	
	@JsonBackReference
	@OneToOne
	public Peg peg;
	

}
