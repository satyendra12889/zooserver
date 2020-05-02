package com.satyendra.iris.zoo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "zoo")
@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
	
	@Id
	public int id;
	
	public String name;
	
	@OneToMany(mappedBy = "zoo")
	public Set<Pen> pens;

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

	public Set<Pen> getPens() {
		return pens;
	}

	public void setPens(Set<Pen> pens) {
		this.pens = pens;
	}

}
