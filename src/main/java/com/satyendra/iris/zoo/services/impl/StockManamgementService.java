package com.satyendra.iris.zoo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.satyendra.iris.validator.Validator;
import com.satyendra.iris.zoo.buutil.ZooAnimalValidation;
import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.dao.IAreaDao;
import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.dao.IStockDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;
import com.satyendra.iris.zoo.services.IAreaAndPenService;
import com.satyendra.iris.zoo.services.IStockService;
@Service
public class StockManamgementService implements IStockService  {

	@Autowired
	IStockDao stockDao;
	@Autowired
	IAreaDao areadao;
	
	@Autowired
	IAnimalDao animalDao;
	
	@Autowired
	IPenDao pendao;
	
	@Override
	public int addStock(String stockName, int animalId, int penId) {
		
		Validator v = ZooAnimalValidation.getValidator();

		boolean canAdd = true;
		Stock s = new Stock();
		s.setName(stockName);
		Animal anim = new Animal();
		anim.setId(animalId);
		s.setAnimal(anim);
		
		// check pen id 
		if(penId > 0) {
			
			Pen p = new Pen();
			Pen p1 = pendao.getPen(penId);
			Animal a = animalDao.getAnimals(animalId);
			p.setId(penId);
			s.setPen(p);
			s.setAnimal(a);
			canAdd = v.validate(s, p1);
		}
		
		if(canAdd) {
		stockDao.add(s);
		}
		
		return s.Id;
	}

	@Override
	public void updateStock(int stockId, int penId) {
		if(stockId >0) {
			Stock s = stockDao.get(stockId);
			Pen p = new Pen();
			p.setId(penId);
			s.setPen(p);
			stockDao.update(s);
		}
	}

}
