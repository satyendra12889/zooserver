package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;

public interface IAnimalService {
	
	Animal getAnimal(int id);
	
	List<Animal> getAllAnimalFromZoo(int zooId);
	
	void addAnimal(String name, int pegId, int animalType);
	

}
