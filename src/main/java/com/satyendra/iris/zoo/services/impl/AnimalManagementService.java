package com.satyendra.iris.zoo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.services.IAnimalService;

@Service
public class AnimalManagementService implements IAnimalService {

	@Autowired
	public IAnimalDao animalDao;
	
	@Override
	public Animal getAnimal(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Animal> getAllAnimalFromZoo(int penId) {
		return animalDao.getAnimalInZoo(penId);
	}

	@Override
	public int addAnimal(AnimalRequestDto animalDto) {
	    Animal animal  = new Animal();
	    animal.setName(animalDto.getAnimalName());
	    animal.setType(animalDto.getType());
	    Pen pen = new Pen();
	    pen.setId(animalDto.getPenId());
	    animal.setPen(pen);
	    return animalDao.addAnimal(animal);

	}

}
