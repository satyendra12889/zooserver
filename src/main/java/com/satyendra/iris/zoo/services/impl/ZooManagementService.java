package com.satyendra.iris.zoo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IPegDao;
import com.satyendra.iris.zoo.dao.IZooDao;
import com.satyendra.iris.zoo.model.Peg;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.services.IZooAndPegService;

@Service
public class ZooManagementService implements IZooAndPegService {

	@Autowired
	public IZooDao zooservice;
	
	@Autowired
	public IPegDao pegservice;
	
	@Override
	public void addZooSpace(String name) {
		
		Zoo z = new Zoo();
		z.name = name;
		int id = zooservice.addZoo(name);
	}

	@Override
	public List<Zoo> allZooSpaces() {
		
		return zooservice.list();
	}

	@Override
	public void addPeg(int zooId, String name) {

		pegservice.addPeg(name);
		
	}

	@Override
	public List<Peg> allPegsFromZoo(int zooid) {
		return pegservice.list(zooid);
	}
	
	

}
