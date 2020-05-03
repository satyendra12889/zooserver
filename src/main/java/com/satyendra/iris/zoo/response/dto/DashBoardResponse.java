package com.satyendra.iris.zoo.response.dto;

import java.util.List;

public class DashBoardResponse {
	
	List<AreaDto> allArea;
	
	List<AnimalDto> animal;
	
	int totalAnimalCount = 0;
	
	public List<AreaDto> getAllArea() {
		return allArea;
	}

	public void setAllArea(List<AreaDto> allArea) {
		this.allArea = allArea;
	}

	public List<AnimalDto> getAnimal() {
		return animal;
	}

	public void setAnimal(List<AnimalDto> animal) {
		this.animal = animal;
	}

	public int getTotalAnimalCount() {
		return totalAnimalCount;
	}

	public void setTotalAnimalCount(int totalAnimalCount) {
		this.totalAnimalCount = totalAnimalCount;
	}
}
