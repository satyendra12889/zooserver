package com.satyendra.iris.zoo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peg")
public class Peg {
	
	@Id
	public int id;
	
	public String name;
	
	@ManyToOne
	public Zoo zoo;
	
//	@ja
//	@OneToOne
//	public Animal anml;
//	
	

}
