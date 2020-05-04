package com.satyendra.iris.validator;

public interface IValidate<T,V> {

	Boolean validate(T s, V a);

}
