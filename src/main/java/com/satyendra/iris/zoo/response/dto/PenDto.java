package com.satyendra.iris.zoo.response.dto;

public class PenDto {
	
	int pegId;
	
	String pegName;
	
	AnimalDto animal;
	
	int available;

	public int getPegId() {
		return pegId;
	}

	public void setPegId(int pegId) {
		this.pegId = pegId;
	}

	public String getPegName() {
		return pegName;
	}

	public void setPegName(String pegName) {
		this.pegName = pegName;
	}

	public AnimalDto getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDto animal) {
		this.animal = animal;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

}
