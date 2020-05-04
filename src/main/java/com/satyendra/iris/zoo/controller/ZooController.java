
package com.satyendra.iris.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.AreaRequestDto;
import com.satyendra.iris.zoo.request.dto.DashBoardRequestDto;
import com.satyendra.iris.zoo.response.dto.PenResponse;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.DashBoardResponse;
import com.satyendra.iris.zoo.response.dto.MessageResponse;
import com.satyendra.iris.zoo.services.IAreaAndPenService;

@RestController
public class ZooController {

    @Autowired
    public IAreaAndPenService areaService;

    @PostMapping("/area/add")
    public ResponseEntity<MessageResponse> addArea(@RequestBody AreaRequestDto area) {
        // area could not be created without pen.
    	if(area.getQty()>0 && area.getName()!=null) {
    	
    	 areaService.addAreaSpace(area.getName(),area.getQty());
    	MessageResponse m = new MessageResponse();
			m.setMsg("area is created successfully");
    	
        return new ResponseEntity<MessageResponse>(m, HttpStatus.CREATED);
    	
    	}else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
        }
    }

    @GetMapping("/area")
    public ResponseEntity<List<AreaResponse>> getarea() {
        List<AreaResponse> areas = areaService.getAllAreaSpaces();
        return new ResponseEntity<List<AreaResponse>>(areas, HttpStatus.OK);
    }
    
	@GetMapping("/area/{id}")
	public ResponseEntity<AreaResponse> getarea(@PathVariable("id") int id){
		AreaResponse area = areaService.getAreaSpaces(id);
		
	    return new ResponseEntity<AreaResponse>(area, HttpStatus.OK);
	}
	
	@GetMapping("/area/available/{id}")
	public ResponseEntity<List<PenResponse>> getAvailableArea(@PathVariable("id") int id){
		List<PenResponse> area = areaService.availablePensFromArea(id);
		
	    return new ResponseEntity<List<PenResponse>>(area, HttpStatus.OK);
	}

    public void removearea() {

    }

    @PostMapping("/pen/add")
    public ResponseEntity<String> addPen(@RequestBody PenRequestDto pen) {
        areaService.addPen(pen);
        return new ResponseEntity<String>("Pen is successfully created", HttpStatus.CREATED);
    }

    @GetMapping("/pen/filled/{id}")
    @ResponseBody
    public ResponseEntity<List<PenResponse>> getFilledPen(@PathVariable("id") int areaId) {
        return new ResponseEntity<List<PenResponse>>(areaService.filledPensFromArea(areaId), HttpStatus.OK);
        
    }
    
    @GetMapping("/dashboard")
    @ResponseBody
    public ResponseEntity<DashBoardResponse> getDashBoard(@RequestParam int animalType,@RequestParam int areaId, @RequestParam int penId  ) {
        return new ResponseEntity<DashBoardResponse>(areaService.getDashBoardResponse(  animalType,   areaId,   penId), HttpStatus.OK);
        
    }

}
