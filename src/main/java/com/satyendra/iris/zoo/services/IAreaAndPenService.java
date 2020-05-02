
package com.satyendra.iris.zoo.services;

import java.util.List;

import com.satyendra.iris.zoo.request.dto.AreaRequestDto;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.response.dto.AreaResponse;
import com.satyendra.iris.zoo.response.dto.PenResponse;

public interface IAreaAndPenService {
	
	void addAreaSpace(AreaRequestDto zoo);
	
	List<AreaResponse> getAllAreaSpaces();

	AreaResponse getAreaSpaces(int zooId);
	
	void addPen(PenRequestDto pen);
	
	List<PenResponse> allPensFromArea(int zooid);

}
