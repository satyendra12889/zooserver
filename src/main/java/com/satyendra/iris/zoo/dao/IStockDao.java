package com.satyendra.iris.zoo.dao;

import java.util.List;

import com.satyendra.iris.zoo.model.Stock;

public interface IStockDao {

	int add(Stock s);
	
	List<Stock> list();
	
	Stock get(int stockId);
	
	void update(Stock s);
	
}
