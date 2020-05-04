package com.satyendra.iris.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Stock;

public class Validator  implements IValidate<Stock, Area>{
	
	List<IValidate> ruleValidate;
	
	
	public Validator() {
		super();
		ruleValidate = new ArrayList<>();
	}

	public void addRule(IValidate rule) {
		ruleValidate.add(rule);
	}
	
	@Override
	public Boolean validate(Stock s, Area a) {
		
		for (Iterator iterator = ruleValidate.iterator(); iterator.hasNext();) {
			IValidate iValidate = (IValidate) iterator.next();
			iValidate.validate(s, a);
		}
		
		return null;
	}

}
