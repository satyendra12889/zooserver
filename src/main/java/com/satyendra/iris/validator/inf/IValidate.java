package com.satyendra.iris.validator.inf;

public interface IValidate<T,V> {

	Boolean validate(T s, V a);

}
