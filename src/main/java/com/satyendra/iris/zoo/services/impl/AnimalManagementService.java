package com.satyendra.iris.zoo.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AnimalTypeDto;
import com.satyendra.iris.zoo.response.dto.AnimalTypeResponse;
import com.satyendra.iris.zoo.response.dto.AreaDto;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.PenResponse;
import com.satyendra.iris.zoo.response.dto.StockDto;
import com.satyendra.iris.zoo.services.IAnimalService;

@Service
public class AnimalManagementService implements IAnimalService {

	@Autowired
	public IAnimalDao animalDao;

	@Autowired
	public IPenDao penDao;

	@Override
	public AnimalDto getAnimal(int id) {

		Animal animal = animalDao.getAnimals(id);
		AnimalDto animDto = new AnimalDto();
		animDto.setAnimalId(animal.getId());
		animDto.setAnimalName(animal.getName());
		animDto.setType(AnimalType.getAnimalType(animal.getType()).getName());
		animDto.setTypeId(animal.getType());
		List<StockDto> stockdtos = new ArrayList<>();
		Set<Stock> stocks =  animal.getStock();
		for (Iterator iterator = stocks.iterator(); iterator.hasNext();) {

			Stock stock = (Stock) iterator.next();
			StockDto dto = new StockDto();
			dto.setStockId(stock.getId());
			dto.setStockName(stock.getName());
			if(stock.getPen() !=null)
			{
				Pen pen  = stock.getPen();
				PenDto pdto = new PenDto();
				pdto.setPegId(pen.getId());
				pdto.setPegName(pen.getName());
				Area area = pen.getArea();
				AreaDto adto = new AreaDto();
				adto.setAreaId(area.getId());
				adto.setAreaName(area.getName());
			}
			stockdtos.add(dto);			
		}



		return animDto;
	}

	@Override
	public List<Animal> getAllAnimalFromArea(int penId) {
		return animalDao.getAnimalInArea(penId);
	}

	@Override
	public int addAnimal(AnimalRequestDto animalDto) {
		Animal animal = new Animal();
		animal.setName(animalDto.getAnimalName());
		animal.setType(animalDto.getType());
		return animalDao.addAnimal(animal);
	}

	@Override
	public List<AnimalResponse> getAll() {
		List<AnimalResponse> res = new ArrayList<AnimalResponse>();

		List<Animal> animals = animalDao.getAllAnimals();
		//        List<Pen> pens = penDao.getAllPens();
		//        Map<Integer, Area> map = new HashMap<>();
		//
		//        for (Pen p : pens) {
		//            map.put(p.getId(), p.getArea());
		//        }
		//
		for (Animal a : animals) {
			AnimalResponse as = new AnimalResponse();
			as.setAnimalId(a.getId());
			as.setAnimalName(a.getName());
			//            as.setPenResponse(getPenResponse(a.getPen()));
			//            as.setAreaResponse(getAreaResponse(map.get(a.getPen().getId())));
			res.add(as);
		}

		return res;
	}

	PenResponse getPenResponse(Pen p){
		PenResponse ps = new PenResponse();
		ps.setPegName(p.name);
		ps.setPegId(p.getId());
		return ps;
	}

	AreaResponse getAreaResponse(Area a) {
		AreaResponse as  = new AreaResponse();
		as.setAreaName(a.getName());
		as.setAreaId(a.getId());
		return as;
	}

	@Override
	public List<AnimalTypeDto> getAnimalType() {
		List<AnimalTypeDto> atr = new ArrayList<>();

		AnimalType[] arr = AnimalType.values();
		for (AnimalType animalType : arr) {
			AnimalTypeDto adto = new AnimalTypeDto();
			adto.setCodeId(animalType.getNumVal());
			adto.setName(animalType.getName());
			atr.add(adto);
		}

		return atr;
	}
}
