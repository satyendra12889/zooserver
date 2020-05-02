package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Area;

public interface IAreaDao {
	
	int addArea(Area zoo);
	
	Area getArea(int id);
	
	List<Area> list();
	

}
