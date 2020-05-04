package com.satyendra.iris.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.response.dto.AnimalResponse;
import com.satyendra.iris.zoo.response.dto.AnimalTypeDto;
import com.satyendra.iris.zoo.response.dto.MessageResponse;
import com.satyendra.iris.zoo.services.IAnimalService;

@Controller
@RestController
public class AnimalController {

    // TODO depend on the subtype
    @Autowired
    public IAnimalService animalService;

    @PostMapping("animal/add")
    public ResponseEntity<MessageResponse> addAnimal(@RequestBody AnimalRequestDto animal) {
       
    	animalService.addAnimal(animal);
    	MessageResponse m = new MessageResponse();
    	
    	m.setMsg("Animal was successfully added to Pen in Zoo");
        return new ResponseEntity<MessageResponse>(m, HttpStatus.CREATED);
    }

    @GetMapping("animal/list/{id}")
    public @ResponseBody List<Animal> getAnimals(@PathVariable("id") int zooId) {
        return animalService.getAllAnimalFromArea(zooId);
    }
    
    
    @GetMapping("animal/type/list")
    public  ResponseEntity<List<AnimalTypeDto>> getAnimalType() {
        return new ResponseEntity<List<AnimalTypeDto>>(animalService.getAnimalType(), HttpStatus.OK);
    }


    @GetMapping("animal/all")
    public ResponseEntity<List<AnimalResponse>> getAllAnimals() {
        List<AnimalResponse> res = animalService.getAll();
        return new ResponseEntity<List<AnimalResponse>>(res, HttpStatus.OK);
    }
    
    @GetMapping("animal/{id}")
    public ResponseEntity<AnimalResponse> getAnimal(@PathVariable("id") int id){
    	AnimalResponse res = animalService.getAnimal(id);
        return new ResponseEntity<AnimalResponse>(res, HttpStatus.OK);
    }

}
