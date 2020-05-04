package com.satyendra.iris.validator.criteria;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.satyendra.iris.validator.criteria.inf.ICriteria;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;

public class NotContainCriteria implements ICriteria<Animal> {

	Set<String> animals;

	Map<Integer, AnimalType> animalType;
	
	
	public NotContainCriteria() {
		super();
		animals = new HashSet();
		animalType = new HashMap<>();
	}

	public void addAnimal(String a) {
		animals.add(a);

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
			if((animals.contains(item.getName())
					|| animalType.containsKey(item.getType()))
					&& (animals.contains(pen.getName())
							||animalType.containsKey(pen.type))) {
				return false;
			}
		return true;
	}

	@Override
	public boolean satisfyCriteria(Animal item) {
		if(animals.contains(item.getName())) {
		return false;
		}
		if(animalType.containsKey(item.getType())) {
			return false;
		}
		return true;
	}

	public Set<String> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<String> animals) {
		this.animals = animals;
	}

	public Map<Integer, AnimalType> getAnimalType() {
		return animalType;
	}

	public void setAnimalType(Map<Integer, AnimalType> animalType) {
		this.animalType = animalType;
	}

}
