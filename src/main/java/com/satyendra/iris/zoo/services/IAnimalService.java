package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AnimalTypeDto;
import com.satyendra.iris.zoo.response.dto.AnimalTypeResponse;

public interface IAnimalService {
	
	AnimalResponse getAnimal(int id);
	
	List<Animal> getAllAnimalFromArea(int areaId);
	
	int addAnimal(AnimalRequestDto animal);
	
	List<AnimalResponse> getAll();
	
	List<AnimalTypeDto> getAnimalType();
	
	
	

}
