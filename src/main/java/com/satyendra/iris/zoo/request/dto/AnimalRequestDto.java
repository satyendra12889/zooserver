package com.satyendra.iris.zoo.request.dto;

import com.satyendra.iris.zoo.model.AnimalType;

import lombok.Getter;
import lombok.Setter;


public class AnimalRequestDto {
    String animalName;
    AnimalType type; 
    Integer penId;
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public AnimalType getType() {
		return type;
	}
	public void setType(AnimalType type) {
		this.type = type;
	}
	public Integer getPenId() {
		return penId;
	}
	public void setPenId(Integer penId) {
		this.penId = penId;
	}
    
    
}
