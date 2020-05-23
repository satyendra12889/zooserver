package com.satyendra.iris.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.satyendra.iris.validator.inf.IValidate;
import com.satyendra.iris.validator.inf.IValidator;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class Validator implements IValidator<Stock, Pen>{
	
	List<IValidate<Stock, Pen>> ruleValidate;
	
	
	public Validator() {
		super();
		ruleValidate = new ArrayList<>();
	}

	@Override
	public void addRule(IValidate<Stock, Pen> rule) {
		ruleValidate.add(rule);
	}
	
	@Override
	public Boolean validate(Stock s, Pen a) {
		
		for (Iterator iterator = ruleValidate.iterator(); iterator.hasNext();) {
			IValidate<Stock, Pen> iValidate = (IValidate) iterator.next();
			if(!iValidate.validate(s, a)) {
				return false;
			}
		}
		
		return true;
	}

}
