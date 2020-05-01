package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Peg;

public interface IPegDao {
	
	
	int addPeg(String name);
	
	int addPeg(Peg p);
	
	Peg getPeg(int id);
	
	List<Peg> list(int zooId);

}
