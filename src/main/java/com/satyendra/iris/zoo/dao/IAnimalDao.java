package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;

public interface IAnimalDao {

	int addAnimal(Animal animal);
	
	Animal getAnimals(int id);
	
	List<Animal> getAnimalInZoo(int zooId);
	
}
