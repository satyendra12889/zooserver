package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;

public interface IAnimalDao {

	int addAnimal(Animal animal);
	
	Animal getAnimals(int id);
	
	List<Animal> getAnimalInArea(int areaId);
	
	List<Animal> getAllAnimals();
	
	List<Animal> getAllAnimals(int animaltype, int areaId, int penId );
	
}
