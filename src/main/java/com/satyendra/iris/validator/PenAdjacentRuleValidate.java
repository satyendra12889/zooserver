package com.satyendra.iris.validator;

import java.util.Set;

import com.satyendra.iris.validator.criteria.ICriteria;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class PenAdjacentRuleValidate implements IValidate<Stock, Pen> {

	
	ICriteria<Animal> criteira;

	public PenAdjacentRuleValidate(ICriteria<Animal> animCriteria) {
		super();
		criteira = animCriteria;
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

		if(!check(s, leftPen) ||! check(s, rightPen)){
			return false;
		}
		return true;
	}

	private boolean check(Stock s, Pen leftPen) {
		if(leftPen.getStock()!=null) {

		return criteira.satisfyCriteria(s.getAnimal(), leftPen.getStock().getAnimal());	

		}
		return true;
	}


}
