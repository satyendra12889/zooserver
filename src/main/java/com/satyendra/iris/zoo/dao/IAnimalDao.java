package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;

public interface IAnimalDao {

	int addAnimal(String name, int peg_id, int type_id);
	
	Animal getAnimals(int id);
	
	List<Animal> getAnimalInZoo(int zooId);
	
}
