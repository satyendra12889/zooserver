package com.satyendra.iris.zoo.response.dto;

import java.util.List;

import com.satyendra.iris.zoo.model.AnimalType;

public class AnimalTypeResponse {
	
	List<AnimalType> animalType;

	public List<AnimalType> getAnimalType() {
		return animalType;
	}

	public void setAnimalType(List<AnimalType> animalType) {
		this.animalType = animalType;
	}

}
