package com.satyendra.iris.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class PenAdjacentRuleValidate implements IValidate<Stock, Pen> {

	List<Animal> animals;
	
	AnimalType animalType;
	
	public PenAdjacentRuleValidate(AnimalType type) {
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
		int size = pens.size();
		int serialno = a.getSerialNo();
		int leftPenNo = serialno != 0? serialno-1:size-1;
		int rightPenNo = serialno != size-1?serialno+1: 0;
		Pen leftPen = null;
		Pen rightPen = null;
		for (Pen pen : pens) {
			if(leftPenNo == pen.getSerialNo()) {
				leftPen = pen;
			}
			if(rightPenNo == pen.getSerialNo()) {
				rightPen = pen;
			}
		}
		
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
