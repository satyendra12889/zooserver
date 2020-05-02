
package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;

public interface IZooAndPenService {
	
	void addZooSpace(ZooRequestDto zoo);
	
	List<Zoo> getAllZooSpaces();
	
	void addPen(PenRequestDto pen);
	
	List<Pen> allPegsFromZoo(int zooid);

}
