package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Pen;

public interface IPenDao {
	
	
	int addPen(String name);
	
	int addPen(Pen p);
	
	Pen getPen(int id);
	
	List<Pen> list(int zooId);
	
	List<Pen> getAllPens();

}
