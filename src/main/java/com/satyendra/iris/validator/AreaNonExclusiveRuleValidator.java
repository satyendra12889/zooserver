package com.satyendra.iris.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.satyendra.iris.validator.criteria.ICriteria;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class AreaNonExclusiveRuleValidator implements IValidate<Stock, Pen> {

	ICriteria<Animal> criteria;

	public AreaNonExclusiveRuleValidator( ICriteria<Animal> criterial) {
		super();
		this.criteria = criterial;
	}

	@Override
	public Boolean validate(Stock s, Pen a) {
		Set<Pen> pens = a.getArea().getPens();
		
		if(!criteria.satisfyCriteria(s.getAnimal())) {
			for (Pen pen : pens) {
				if(pen.getStock() !=null && pen.getStock().getAnimal().getId() != s.getAnimal().getId()) {
					if(!criteria.satisfyCriteria(s.getAnimal(), pen.getStock().getAnimal())) {
						return false;
					}
				}
			}
		}

		return true;
	}




}
