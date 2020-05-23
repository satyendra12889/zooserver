package com.satyendra.iris.validator.inf;

public interface IValidator<T, V> extends IValidate<T, V> {
	
	
	public void addRule(IValidate<T, V> rule);

}
