package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int Id;
	
	public String name;
	
	@ManyToOne
	public Animal animal;
	
		
	@OneToOne
	public Pen pen;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public Pen getPen() {
		return pen;
	}


	public void setPen(Pen pen) {
		this.pen = pen;
	}

}
