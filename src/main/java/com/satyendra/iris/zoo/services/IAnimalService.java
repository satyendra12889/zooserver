package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;

public interface IAnimalService {
	
	Animal getAnimal(int id);
	
	List<Animal> getAllAnimalFromArea(int areaId);
	
	int addAnimal(AnimalRequestDto animal);
	
	List<AnimalResponse> getAll();
	
	
	

}
