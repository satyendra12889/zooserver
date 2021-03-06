package com.satyendra.iris.zoo.buutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.satyendra.iris.validator.AreaNonExclusiveRuleValidator;
import com.satyendra.iris.validator.PenAdjacentRuleValidate;
import com.satyendra.iris.validator.Validator;
import com.satyendra.iris.validator.criteria.BearAndBirdCriteria;
import com.satyendra.iris.validator.criteria.NotContainCriteria;
import com.satyendra.iris.validator.inf.IValidate;
import com.satyendra.iris.validator.inf.IValidator;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

@Configuration
public class ZooAnimalValidation {
	
	
	
	@Bean
	public IValidator getValidator(){
		
		NotContainCriteria bearandBirdCriteria = new BearAndBirdCriteria();
		bearandBirdCriteria.addAnimal("polar bear");
		bearandBirdCriteria.addAnimal("black bear");
		bearandBirdCriteria.addAnimal("brown bear");
		bearandBirdCriteria.addAnimalType(AnimalType.BIRDFLY);
		bearandBirdCriteria.addAnimalType(AnimalType.BIRDNONFLY);
		
		
		NotContainCriteria reptileCriteria = new NotContainCriteria();
		reptileCriteria.addAnimalType(AnimalType.BIRDFLY);
		reptileCriteria.addAnimalType(AnimalType.BIRDNONFLY);
		reptileCriteria.addAnimalType(AnimalType.REPTILE);
		
		
		IValidate<Stock, Pen> penruleValidation = new PenAdjacentRuleValidate(bearandBirdCriteria);
		IValidate<Stock, Pen> arearuleValidation = new AreaNonExclusiveRuleValidator(reptileCriteria);
		
		
		IValidator<Stock, Pen> validator = new Validator();
		validator.addRule(penruleValidation);
		validator.addRule(arearuleValidation);
		return validator;
		
		
	}
	
	
}
