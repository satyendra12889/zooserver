package com.satyendra.iris.zoo.model;

import java.util.Iterator;

public enum AnimalType {
	BIRD(0, "Bird"),
	MAMMAL(1, "Mammal"), 
	REPTILE(2, "Reptile");

	private int numVal;
	private String name;

	AnimalType(int code , String value ) {
		this.numVal = code;
		this.name = value;
	}

	public int getNumVal() {
		return numVal;
	}
	
	public String getName() {
		return name;
	}

	
	public static AnimalType getAnimalType(int id) {
		for(AnimalType a:values()) {
			if(a.getNumVal()==id) {
				return a;
			}
		}
		return null;
	}
}
