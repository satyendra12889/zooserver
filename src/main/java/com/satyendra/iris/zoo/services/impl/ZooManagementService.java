
package com.satyendra.iris.zoo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.dao.IAreaDao;
import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AreaDto;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.DashBoardResponse;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.PenResponse;
import com.satyendra.iris.zoo.response.dto.StockDto;
import com.satyendra.iris.zoo.services.IAreaAndPenService;

@Service
public class ZooManagementService implements IAreaAndPenService {

	@Autowired
	public IAreaDao areaDao;

	@Autowired
	public IPenDao penDao;

	@Autowired
	public IAnimalDao animalDao;

	@Override
	public void addAreaSpace(String name , int qty) {

		Area z = new Area();
		z.name = name;
		z.qty  = qty;
		//TODO Make it transactional so any service fail then we have consistency 
		int id = areaDao.addArea(z);
		if(id >0) {
			for (int i = 0; i < qty; i++) {
				Pen p = new Pen();
				p.name = z.getName() + "_Pen_" + i;
				p.setSerialNo(i);
				p.setArea(z);
				penDao.addPen(p);
			}	
		}
	}

	@Override
	public List<AreaResponse> getAllAreaSpaces() {

		List<Area> zoos = areaDao.list();
		List<AreaResponse> areaResponses = new ArrayList<>();
		for (int i = 0; i < zoos.size(); i++) {
			AreaResponse  dto = new AreaResponse();
			Area z = zoos.get(i);
			dto.setAreaId(z.id);
			dto.setAreaName(z.name);
			areaResponses.add(dto);
		}
		return areaResponses;
	}

	@Override
	public DashBoardResponse getDashBoardResponse(int animalType, int  areaId, int   penId) {

		DashBoardResponse dsresp = new DashBoardResponse();
		// area response 
		// animal response

		List<Area> zoos = areaDao.list();
		List<AreaDto> areaResponses = new ArrayList<>();
		for (int i = 0; i < zoos.size(); i++) {
			AreaResponse  dto = new AreaResponse();
			Area z = zoos.get(i);
			dto.setAreaId(z.id);
			dto.setAreaName(z.name);
			areaResponses.add(dto);
		}

		List<AnimalDto> stock = new ArrayList<>();



		List<Animal> animal = animalDao.getAllAnimals(animalType, areaId, penId);

		for (int i = 0; i < animal.size(); i++) {
			AnimalDto  dto = new AnimalDto();
			Animal a = animal.get(i);
			dto.setAnimalId(a.getId());
			dto.setAnimalName(a.getName());

			Set<Stock> stocks = a.getStock();
			List<StockDto> stockList = new ArrayList<>();
			for (Stock s : stocks) {
				StockDto sdto = new StockDto();
				sdto.setStockId(s.getId());
				stockList.add(sdto);
			}
			dto.setStocks(stockList);
			stock.add(dto);
		}

		dsresp.setAllArea(areaResponses);
		dsresp.setAnimal(stock);

		return dsresp;

	}

	@Override
	public void addPen(PenRequestDto penDto) {
		Pen pen = new Pen();
		pen.setName(penDto.getPenName());
		Area zoo  = new Area();
		zoo.setId(penDto.getZooId());
		pen.setArea(zoo);
		penDao.addPen(pen);

	}

	@Override
	public AreaResponse getAreaSpaces(int areaId) {
		Area z = areaDao.getArea(areaId);
		AreaResponse dto  = new AreaResponse();
		dto.setAreaId(areaId);
		dto.setAreaName(z.name);

		Set<Pen> p = z.getPens();

		List<PenDto> pendtos  = new ArrayList<>();

		for (Pen pen : p) {
			PenResponse pdto = new PenResponse();
			AnimalResponse adto = new AnimalResponse();
			pdto.setPegId(pen.getId());
			pdto.setPegName(pen.getName());

			Stock a = pen.getStock();
			if(a!=null) {
				adto.setAnimalId(a.getId());
				adto.setAnimalName(a.getName());
				pdto.setAnimal(adto);

			}
			pendtos.add(pdto);
		}

		dto.setAllPens(pendtos);
		return dto;
	}

	@Override
	public List<PenResponse> filledPensFromArea(int areaId) {

		Area z = areaDao.getArea(areaId);

		Set<Pen> p = z.getPens();

		List<PenResponse> pendtos  = new ArrayList<>();

		for (Pen pen : p) {
			PenResponse pdto = new PenResponse();
			pdto.setPegId(pen.getId());
			pdto.setPegName(pen.getName());
			if(pen.getStock()!=null) {
				pendtos.add(pdto);
			}
		}

		return pendtos;
	}

	@Override
	public List<PenResponse> availablePensFromArea(int areaId) {

		Area z = areaDao.getArea(areaId);

		Set<Pen> p = z.getPens();

		List<PenResponse> pendtos  = new ArrayList<>();

		for (Pen pen : p) {
			PenResponse pdto = new PenResponse();
			pdto.setPegId(pen.getId());
			pdto.setPegName(pen.getName());
			if(pen.getStock()==null) {
				pendtos.add(pdto);
			}
		}
		return pendtos;
	}
}
