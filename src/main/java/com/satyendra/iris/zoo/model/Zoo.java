package com.satyendra.iris.zoo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zoo")
@AllArgsConstructor
@NoArgsConstructor
public class Zoo {
	
	@Id
	public int id;
	
	public String name;
	
	@OneToMany(mappedBy = "zoo")
	public Set<Peg> pegs;

}
