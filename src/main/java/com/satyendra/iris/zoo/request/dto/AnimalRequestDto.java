package com.satyendra.iris.zoo.request.dto;

import com.satyendra.iris.zoo.model.AnimalType;

import lombok.Getter;
import lombok.Setter;


public class AnimalRequestDto {
    String animalName;
    int type; 
    public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
    
    
}
