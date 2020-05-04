package com.satyendra.iris.zoo.buutil;

import org.springframework.stereotype.Component;

import com.satyendra.iris.validator.AreaNonExclusiveRuleValidator;
import com.satyendra.iris.validator.PenAdjacentRuleValidate;
import com.satyendra.iris.validator.Validator;
import com.satyendra.iris.validator.criteria.BearAndBirdCriteria;
import com.satyendra.iris.validator.criteria.NotContainCriteria;
import com.satyendra.iris.validator.inf.IValidate;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

@Component
public class ZooAnimalValidation {
	
	public static Validator getValidator(){
		
		NotContainCriteria bearandBirdCriteria = new BearAndBirdCriteria();
		bearandBirdCriteria.addAnimal("polar bear");
		bearandBirdCriteria.addAnimal("black bear");
		bearandBirdCriteria.addAnimal("brown bear");
		bearandBirdCriteria.addAnimalType(AnimalType.BIRD);
		
		
		NotContainCriteria reptileCriteria = new NotContainCriteria();
		reptileCriteria.addAnimalType(AnimalType.BIRD);
		reptileCriteria.addAnimalType(AnimalType.REPTILE);
		
		
		IValidate<Stock, Pen> penruleValidation = new PenAdjacentRuleValidate(bearandBirdCriteria);
		IValidate<Stock, Pen> arearuleValidation = new AreaNonExclusiveRuleValidator(reptileCriteria);
		
		
		Validator validator = new Validator();
		validator.addRule(penruleValidation);
		validator.addRule(arearuleValidation);
		return validator;
		
		
	}
	
	
}
