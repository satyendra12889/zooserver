package com.satyendra.iris.zoo.response.dto;

import com.satyendra.iris.zoo.model.Pen;

public class AnimalDto {
	
	int animalId;
	
	String type;
	
	String animalName;
	
	Pen pen;
	
	
	int asisgned;


	public int getAnimalId() {
		return animalId;
	}


	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAnimalName() {
		return animalName;
	}


	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}


	public Pen getPen() {
		return pen;
	}


	public void setPen(Pen pen) {
		this.pen = pen;
	}


	public int getAsisgned() {
		return asisgned;
	}


	public void setAsisgned(int asisgned) {
		this.asisgned = asisgned;
	}

}
