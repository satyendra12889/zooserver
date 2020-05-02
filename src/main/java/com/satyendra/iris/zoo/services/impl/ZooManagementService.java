
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
import com.satyendra.iris.zoo.request.dto.AreaRequestDto;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.PenResponse;
import com.satyendra.iris.zoo.services.IAreaAndPenService;

@Service
public class ZooManagementService implements IAreaAndPenService {

    @Autowired
    public IAreaDao areaService;

    @Autowired
    public IPenDao penService;
    
    @Autowired
    public IAnimalDao animalService;

    @Override
    public void addAreaSpace(AreaRequestDto area) {

        Area z = new Area();
        z.name = area.getName();
        int id = areaService.addArea(z);
        System.out.print("zoo Id:"+ id);
    }

    @Override
    public List<AreaResponse> getAllAreaSpaces() {

    	List<Area> zoos = areaService.list();
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
    public void addPen(PenRequestDto penDto) {
        Pen pen = new Pen();
        pen.setName(penDto.getPenName());
        Area zoo  = new Area();
        zoo.setId(penDto.getZooId());
        pen.setArea(zoo);
        penService.addPen(pen);

    }

    

	@Override
	public AreaResponse getAreaSpaces(int areaId) {
		Area z = areaService.getArea(areaId);
		
		List<Animal> animal = animalService.getAnimalInArea(areaId);
		
		AreaResponse dto  = new AreaResponse();
		dto.setAreaId(areaId);
		dto.setAreaName(z.name);
		
		Set<Pen> p = z.getPens();
		
		List<PenResponse> pendtos  = new ArrayList<>();
		List<AnimalResponse> animaldtos  = new ArrayList<>();
		
		for (Pen pen : p) {
			PenResponse pdto = new PenResponse();
			AnimalResponse adto = new AnimalResponse();
			pdto.setPegId(pen.getId());
			pdto.setPegName(pen.getName());
			pendtos.add(pdto);
		}
		
		
		for (Animal animalDto : animal) {
			AnimalResponse adto  = new AnimalResponse();
			adto.setAnimalId(animalDto.getId());
			adto.setAnimalName(animalDto.getName());
			adto.setAsisgned(0);
			animaldtos.add(adto);
		}
		
		dto.setAllPens(pendtos);
		dto.setAllAnimal(animaldtos);
		return dto;


	}

	@Override
	public List<PenResponse> allPensFromArea(int areaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
