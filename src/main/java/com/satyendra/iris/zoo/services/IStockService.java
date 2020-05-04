package com.satyendra.iris.zoo.services;

public interface IStockService {
	
	int addStock(String stockName, int animalId, int penId);
	
	void updateStock(int stockId, int penId);
	
}
