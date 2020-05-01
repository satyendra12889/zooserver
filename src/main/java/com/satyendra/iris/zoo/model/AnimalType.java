package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AnimalType {
	
	@Id
	public int id;
	
	public String name;
	

}
