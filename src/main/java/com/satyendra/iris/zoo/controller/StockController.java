package com.satyendra.iris.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.request.dto.StockRequestDto;
import com.satyendra.iris.zoo.services.IStockService;

@RestController
public class StockController {

	@Autowired
	IStockService stockService;


	@PostMapping("/stock/add")
	public ResponseEntity<String> addArea(@RequestBody StockRequestDto stock) {
		if(stock.getAnimaId()>0 && stock.getName()!=null) {

			stockService.addStock(stock.getName(), stock.getAnimaId(), stock.getPenId());
			return new ResponseEntity<String>("area is created successfully", HttpStatus.CREATED);

		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}



}
