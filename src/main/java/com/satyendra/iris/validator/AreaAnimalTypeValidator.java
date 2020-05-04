package com.satyendra.iris.validator;

import java.util.List;

import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class AreaAnimalTypeValidator implements IValidate<Stock , Pen> {
	
	List<AnimalType> animaltype;
	
	
	@Override
	public Boolean validate(Stock s, Pen a) {
		return null;
	}

}
