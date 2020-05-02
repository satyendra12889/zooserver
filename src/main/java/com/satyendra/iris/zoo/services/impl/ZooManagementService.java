package com.satyendra.iris.zoo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.dao.IZooDao;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalDto;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.ZooDto;
import com.satyendra.iris.zoo.services.IZooAndPenService;

@Service
public class ZooManagementService implements IZooAndPenService {

    @Autowired
    public IZooDao zooService;

    @Autowired
    public IPenDao penService;
    
    @Autowired
    public IAnimalDao animalService;


    @Override
    public void addZooSpace(ZooRequestDto zoo) {

        Zoo z = new Zoo();
        z.name = zoo.getName();
        int id = zooService.addZoo(z);
        System.out.print("zoo Id:"+ id);
    }

    @Override
    public List<ZooDto> getAllZooSpaces() {
    	List<Zoo> zoos = zooService.list();
		List<ZooDto> zooDtos = new ArrayList<>();
	    for (int i = 0; i < zoos.size(); i++) {
			ZooDto  dto = new ZooDto();
			Zoo z = zoos.get(i);
			dto.setZooId(z.id);
			dto.setZooName(z.name);
			zooDtos.add(dto);
		}
	    
        return zooDtos;
    }

    @Override
    public void addPen(PenRequestDto penDto) {
        Pen pen = new Pen();
        pen.setName(penDto.getPenName());
        Zoo zoo  = new Zoo();
        zoo.setId(penDto.getZooId());
        pen.setZoo(zoo);
        penService.addPen(pen);

    }

    @Override
    public List<PenDto> allPegsFromZoo(int zooid) {
        
    	
    	return null;
    }

	@Override
	public ZooDto getZooSpaces(int zooId) {
		
		Zoo z = zooService.getZoo(zooId);
		
//		list<> animal = animalService.getAnimalInZoo(zooId);
		
		ZooDto dto  = new ZooDto();
		dto.setZooId(zooId);
		dto.setZooName(z.name);
		
		Set<Pen> p = z.getPens();
		
		List<PenDto> pendtos  = new ArrayList<>();
		List<AnimalDto> animaldtos  = new ArrayList<>();
		
		for (Pen pen : p) {
			PenDto pdto = new PenDto();
			AnimalDto adto = new AnimalDto();
			pdto.setPegId(pen.getId());
			pdto.setPegName(pen.getName());
			pendtos.add(pdto);
		}
		
		dto.setAllPens(pendtos);
		dto.setAllAnimal(animaldtos);
		return dto;
	}

}
