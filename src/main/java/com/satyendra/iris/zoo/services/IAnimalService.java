package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;

public interface IAnimalService {
	
	Animal getAnimal(int id);
	
	List<Animal> getAllAnimalFromZoo(int zooId);
	
	int addAnimal(AnimalRequestDto animal);
	

}
