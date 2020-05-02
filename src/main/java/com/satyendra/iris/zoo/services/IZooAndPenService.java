package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;
import com.satyendra.iris.zoo.response.dto.PenDto;
import com.satyendra.iris.zoo.response.dto.ZooDto;

public interface IZooAndPenService {
	
	void addZooSpace(ZooRequestDto zoo);
	
	List<ZooDto> getAllZooSpaces();
	
	ZooDto getZooSpaces(int zooId);
	
	void addPen(PenRequestDto pen);
	
	List<PenDto> allPegsFromZoo(int zooid);

}
