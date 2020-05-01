package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Animal {
	
	@Id
	public int id;
	
	public String name; 
	
	public AnimalType type;
	
	
	@OneToOne
	public Pen peg;
	

}
