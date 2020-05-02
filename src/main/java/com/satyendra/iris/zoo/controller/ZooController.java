
package com.satyendra.iris.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.ZooDto;
import com.satyendra.iris.zoo.services.IZooAndPenService;

@RestController
public class ZooController {

    @Autowired
    public IZooAndPenService zooService;

    @PostMapping("/zoo/add")
    public ResponseEntity<String> addZoo(@RequestBody ZooRequestDto zoo) {
        zooService.addZooSpace(zoo);
        return new ResponseEntity<String>("Zoo is created successfully", HttpStatus.CREATED);

    }

    @GetMapping("/zoo")
    public ResponseEntity<List<ZooDto>> getZoo() {
        List<ZooDto> zoos = zooService.getAllZooSpaces();
        return new ResponseEntity<List<ZooDto>>(zoos, HttpStatus.OK);
    }
    
	@GetMapping("/zoo/{id}")
	public ResponseEntity<ZooDto> getZoo(@PathVariable("id") int id){
		ZooDto zoo = zooService.getZooSpaces(id);
		
	    return new ResponseEntity<ZooDto>(zoo,HttpStatus.OK);
	}

    public void removeZoo() {

    }

    @PostMapping("/pen/add")
    public ResponseEntity<String> addPen(PenRequestDto pen) {
        zooService.addPen(pen);
        return new ResponseEntity<String>("Pen is successfully created", HttpStatus.CREATED);

    }

    @GetMapping("/pen/{id}")
    @ResponseBody
    public List<PenDto> getPegs(@PathVariable("id") int zooid) {
        return zooService.allPegsFromZoo(zooid);

    }

}
