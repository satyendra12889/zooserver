package com.satyendra.iris.zoo.services;

import com.satyendra.iris.zoo.request.dto.StockRequestDto;

public interface IStockService {
	
	int addStock(String stockName, int animalId, int penId);
	
	void updateStock(int stockId, int penId);
	
}
