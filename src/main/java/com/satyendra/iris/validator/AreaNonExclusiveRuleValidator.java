package com.satyendra.iris.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class AreaNonExclusiveRuleValidator implements IValidate<Stock, Pen> {

	List<Animal> animals;
	
	public AreaNonExclusiveRuleValidator() {
		super();
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal(Animal a) {
		animals.add(a);
		
	}
	
	public void removeAnimal(int animalId) {
		for (Animal animal : animals) {
			if(animal.getId() == animalId) {
				animals.remove(animal);
				break;
			}
		}
	}
	

	@Override
	public Boolean validate(Stock s, Pen a) {
		Set<Pen> pens = a.getArea().getPens();
		boolean checkItem = false;
		// contains in array 
		for (Animal animal : animals) {
			if(animal.getId() == s.getAnimal().getId()) {
				checkItem = true;
			}
		}
		if(checkItem == true) {
			for (Pen pen : pens) {
				if(pen.getStock() !=null && pen.getStock().getAnimal().getId() != s.getAnimal().getId()) {
					for (Animal anim : animals) {
						if(pen.getStock().getAnimal().getId() == anim.getId()) {
							return false;
						}
					}
					
				}
			}
		}

		return true;
	}

}
