package com.satyendra.iris.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pen")
public class Pen {
	
	@Id
	public int id;
	
	public String name;
	
	@ManyToOne
	public Zoo zoo;

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
	
	@OneToOne(optional=true)
	public Animal anml;

	public Animal getAnml() {
		return anml;
	}

	public void setAnml(Animal anml) {
		this.anml = anml;
	}
	

}
