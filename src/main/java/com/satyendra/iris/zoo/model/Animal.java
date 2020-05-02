package com.satyendra.iris.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Animal {
	
	@Id
	public int id;
	
	public String name; 
	
	public AnimalType type;
	
	
	@OneToOne(optional=true)
	public Pen peg;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public AnimalType getType() {
		return type;
	}


	public void setType(AnimalType type) {
		this.type = type;
	}


	public Pen getPeg() {
		return peg;
	}


	public void setPeg(Pen peg) {
		this.peg = peg;
	}
	

}
