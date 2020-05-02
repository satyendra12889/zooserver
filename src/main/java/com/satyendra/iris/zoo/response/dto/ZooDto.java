package com.satyendra.iris.zoo.response.dto;

import java.util.List;

public class ZooDto {
	
	int zooId;
	
	String zooName;
	
	List<AnimalDto> allAnimal;
	
	List<PenDto> allPens;

	public int getZooId() {
		return zooId;
	}

	public void setZooId(int zooId) {
		this.zooId = zooId;
	}

	public String getZooName() {
		return zooName;
	}

	public void setZooName(String zooName) {
		this.zooName = zooName;
	}

	public List<AnimalDto> getAllAnimal() {
		return allAnimal;
	}

	public void setAllAnimal(List<AnimalDto> allAnimal) {
		this.allAnimal = allAnimal;
	}

	public List<PenDto> getAllPens() {
		return allPens;
	}

	public void setAllPens(List<PenDto> allPens) {
		this.allPens = allPens;
	}
}
