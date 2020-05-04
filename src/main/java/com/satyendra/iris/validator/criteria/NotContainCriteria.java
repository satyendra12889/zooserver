package com.satyendra.iris.validator.criteria;

import java.util.HashMap;
import java.util.Map;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;

public class NotContainCriteria implements ICriteria<Animal> {

	Map<Integer, Animal> animals;

	Map<Integer, AnimalType> animalType;
	
	
	public NotContainCriteria() {
		super();
		animals = new HashMap<>();
		animalType = new HashMap<>();
	}

	public void addAnimal(Animal a) {
		animals.put(a.getId(), a);

	}

	public void removeAnimal(int animalId) {
		animals.remove(animalId);
	}

	
	public void addAnimalType(AnimalType a) {
		animalType.put(a.getNumVal(), a);

	}

	public void removeAnimalType(int animalId) {
		animalType.remove(animalId);
	}

	@Override
	public boolean satisfyCriteria(Animal item, Animal pen) {
		if(item.getType() != pen.getType())
			if((animals.containsKey(item.getId())
					|| animalType.containsKey(item.getType()))
					&& (animals.containsKey(pen.getId())
							||animalType.containsKey(pen.type))) {
				return false;
			}

		
		return true;
	}
	
	

	@Override
	public boolean satisfyCriteria(Animal item) {
		// TODO Auto-generated method stub
		if(animals.containsKey(item.getId())) {
		return false;
		}
		if(animalType.containsKey(item.getType())) {
			return false;
		}
		return true;
	}

}
