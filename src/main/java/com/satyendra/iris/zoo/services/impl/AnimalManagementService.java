package com.satyendra.iris.zoo.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.PenResponse;
import com.satyendra.iris.zoo.services.IAnimalService;

@Service
public class AnimalManagementService implements IAnimalService {

    @Autowired
    public IAnimalDao animalDao;

    @Autowired
    public IPenDao penDao;

    @Override
    public Animal getAnimal(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Animal> getAllAnimalFromArea(int penId) {
        return animalDao.getAnimalInArea(penId);
    }

    @Override
    public int addAnimal(AnimalRequestDto animalDto) {
        Animal animal = new Animal();
        animal.setName(animalDto.getAnimalName());
        //	    animal.setType(animalDto.getType());
        Pen pen = new Pen();
        pen.setId(animalDto.getPenId());
        animal.setPen(pen);
        return animalDao.addAnimal(animal);

    }

    @Override
    public List<AnimalResponse> getAll() {
        List<AnimalResponse> res = new ArrayList<AnimalResponse>();

        List<Animal> animals = animalDao.getAllAnimals();
        List<Pen> pens = penDao.getAllPens();
        Map<Integer, Area> map = new HashMap<>();

        for (Pen p : pens) {
            map.put(p.getId(), p.getArea());
        }

        for (Animal a : animals) {
            AnimalResponse as = new AnimalResponse();
            as.setAnimalName(a.getName());
            
            as.setPenResponse(getPenResponse(a.getPen()));
            as.setAreaResponse(getAreaResponse(map.get(a.getPen().getId())));
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
}
