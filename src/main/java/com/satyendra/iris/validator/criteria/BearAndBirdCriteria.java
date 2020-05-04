package com.satyendra.iris.validator.criteria;

import com.satyendra.iris.zoo.model.Animal;

public class BearAndBirdCriteria extends NotContainCriteria  {

	@Override
	public boolean satisfyCriteria(Animal item, Animal pen) {
		if(item!=null && pen !=null) {
			// item is in animal and  pen in animal or vice versa
			if(item.getType() != pen.getType())
				if((getAnimals().contains(item.getName())
						&& getAnimalType().containsKey(pen.getType()))
						|| (getAnimals().contains(pen.getName())
								&&getAnimalType().containsKey(item.getType()))) {
					return false;
				}
		}
		return  true;
	}

	@Override
	public boolean satisfyCriteria(Animal item) {
		// TODO Auto-generated method stub
		return false;
	}

}
