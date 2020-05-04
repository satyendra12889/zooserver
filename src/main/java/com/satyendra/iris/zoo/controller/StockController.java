package com.satyendra.iris.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.request.dto.StockRequestDto;
import com.satyendra.iris.zoo.response.dto.MessageResponse;
import com.satyendra.iris.zoo.services.IStockService;

@RestController
public class StockController {

	@Autowired
	IStockService stockService;

	@PostMapping("/stock/add")
	public ResponseEntity<MessageResponse> addStock(@RequestBody StockRequestDto stock) {
		if(stock.getAnimaId()>0 && stock.getName()!=null) {

			int id = stockService.addStock(stock.getName(), stock.getAnimaId(), stock.getPenId());
			MessageResponse m = new MessageResponse();
			if(id >0) {
				m.setMsg("Stock was successfully added to Pen in Zoo");
			}else {
				m.setMsg("Stock was not successfully added to Pen in Zoo");
			}
			return new ResponseEntity<MessageResponse>(m, HttpStatus.CREATED);

		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
}
