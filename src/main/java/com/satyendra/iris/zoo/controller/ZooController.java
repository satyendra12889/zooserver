package com.satyendra.iris.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.model.Peg;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.services.IZooAndPegService;
@RestController
public class ZooController {
	
	@Autowired
	public IZooAndPegService zooService;
	
	public void addZoo() {
		
	}
	
	@GetMapping("/zoo")
	public @ResponseBody List<Zoo> getZoo(){
		return zooService.allZooSpaces();
	}
	
	public void removeZoo(){
		
	}
	
	public void addPeg() {
		
	}
	@GetMapping("/peg/{id}")
	@ResponseBody
	public List<Peg> getPegs(@PathVariable("id") int zooid) {
		
		return zooService.allPegsFromZoo(zooid);
		
	}

}
