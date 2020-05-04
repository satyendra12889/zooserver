package com.satyendra.iris.validator.criteria;

public interface ICriteria <T>{
	
	boolean satisfyCriteria(T item, T Pen);
	
	boolean satisfyCriteria(T item);

}
