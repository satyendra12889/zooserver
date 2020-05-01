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
import com.satyendra.iris.zoo.request.dto.AnimalRequestDto;
import com.satyendra.iris.zoo.services.IAnimalService;
@Controller
@RestController("/animal")
public class AnimalController {
	
	// TODO depend on the subtype
	@Autowired
	public IAnimalService animalService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addAnimal(@RequestBody AnimalRequestDto animal) {
	     animalService.addAnimal(animal);
	     return new ResponseEntity<String>("Animal was successfully added to Pen in Zoo", HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public @ResponseBody List<Animal> getAnimals(@PathVariable int zooId){
		return animalService.getAllAnimalFromZoo(zooId);
	}
	

}
