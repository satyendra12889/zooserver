package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Peg;
import com.satyendra.iris.zoo.model.Zoo;

public interface IZooAndPegService {
	
	void addZooSpace(String name);
	
	List<Zoo> allZooSpaces();
	
	void addPeg(int zooId, String name);
	
	List<Peg> allPegsFromZoo(int zooid);

}
