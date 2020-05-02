package com.satyendra.iris.zoo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.ZooDto;
import com.satyendra.iris.zoo.services.IZooAndPenService;
@RestController
public class ZooController {
	
	@Autowired
	public IZooAndPenService zooService;
	
	@PostMapping("/zoo/add")
	public ResponseEntity<String> addZoo(ZooRequestDto zoo) {
	    zooService.addZooSpace(zoo);
	    return new ResponseEntity<String>("Zoo is created successfully", HttpStatus.CREATED);
		
	}
	
	@GetMapping("/zoo")
	public ResponseEntity<List<ZooDto>> getZoo(){
	    
	    return new ResponseEntity<List<ZooDto>>(zooService.getAllZooSpaces(),HttpStatus.OK);
	}
	
	@GetMapping("/zoo/{id}")
	public ResponseEntity<ZooDto> getZoo(@PathVariable("id") int id){
		ZooDto zoo = zooService.getZooSpaces(id);
		
	    return new ResponseEntity<ZooDto>(zoo,HttpStatus.OK);
	}
	
	public void removeZoo(){
		
	}
	
	public void addPeg() {
		
	}
	@GetMapping("/pen/{id}")
	@ResponseBody
	public List<PenDto> getPegs(@PathVariable("id") int zooid) {
		
		return null;//zooService.allPegsFromZoo(zooid);
		
	}

}
