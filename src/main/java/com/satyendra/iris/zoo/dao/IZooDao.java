package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Zoo;

public interface IZooDao {
	
	int addZoo(Zoo zoo);
	
	Zoo getZoo(int id);
	
	List<Zoo> list();
	

}
