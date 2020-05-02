package com.satyendra.iris.zoo.response.dto;

public class PenResponse {
	
	int pegId;
	
	String pegName;
	
	AnimalResponse animal;
	
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

	public AnimalResponse getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalResponse animal) {
		this.animal = animal;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	

}
