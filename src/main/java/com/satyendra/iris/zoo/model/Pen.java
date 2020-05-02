
package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="pen")
public class Pen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String name;
	
	@ManyToOne
	public Zoo zoo;
	

	@OneToOne
	public Animal anml;


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


	public Zoo getZoo() {
		return zoo;
	}


	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}


	public Animal getAnml() {
		return anml;
	}


	public void setAnml(Animal anml) {
		this.anml = anml;
	}

}
