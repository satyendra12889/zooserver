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
@Getter
@Setter
@Table(name = "zoo")
@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
	
	@Id
	public int id;
	
	public String name;
	
	@OneToMany(mappedBy = "zoo")
	public Set<Pen> pens;

}
