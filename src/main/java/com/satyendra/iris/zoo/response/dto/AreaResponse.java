package com.satyendra.iris.zoo.response.dto;

import java.util.List;

public class AreaResponse {
	
	int areaId;
	
	String areaName;
	
	List<AnimalResponse> allAnimal;
	
	List<PenResponse> allPens;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public List<AnimalResponse> getAllAnimal() {
		return allAnimal;
	}

	public void setAllAnimal(List<AnimalResponse> allAnimal) {
		this.allAnimal = allAnimal;
	}

	public List<PenResponse> getAllPens() {
		return allPens;
	}

	public void setAllPens(List<PenResponse> allPens) {
		this.allPens = allPens;
	}
}
