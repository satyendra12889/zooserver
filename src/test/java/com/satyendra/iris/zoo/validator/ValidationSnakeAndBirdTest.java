package com.satyendra.iris.zoo.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.satyendra.iris.validator.inf.IValidator;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.AnimalType;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Stock;

public class ValidationSnakeAndBirdTest {

	@Autowired
	IValidator<Stock, Pen> v;
	
//	 test case  snake is beside bird validation breaks 
	@Test
	public void validateSnakecase1() {
		
		Animal animbrear = new Animal();
		animbrear.setId(1);
		animbrear.setName("Snake");
		animbrear.setType(AnimalType.REPTILE.getNumVal());
		
		
		Animal animbreard = new Animal();
		animbreard.setId(2);
		animbreard.setName("bird");
		animbreard.setType(AnimalType.BIRDFLY.getNumVal());
		
		
		Area a = new Area();
		a.setId(1);
		a.setName("area 1");
		Set<Pen> pset = new HashSet<>();
		a.setPens(pset);
		Pen p = new  Pen();
		p.setArea(a);
		p.setId(1);
		p.setName("pen1");
		p.setSerialNo(0);
		
		
		pset.add(p);
		
		Pen p2 = new  Pen();
		p2.setArea(a);
		p2.setId(2);
		p2.setName("pen2");
		p2.setSerialNo(1);
		
		pset.add(p2);
		
		Pen p3 = new  Pen();
		p3.setArea(a);
		p3.setId(3);
		p3.setName("pen3");
		p3.setSerialNo(2);
		
		pset.add(p3);
		
		//animalDao.getAnimals(animalId);
		Stock sbear = new Stock();
		sbear.setAnimal(animbrear);
		sbear.setId(1);
		sbear.setPen(p);
		p.setStock(sbear);
		
		Stock sbird = new Stock();
		sbird.setAnimal(animbreard);
		
		assertFalse(v.validate(sbird, p2));
		
	}
	
	// test case  snake with another animal  validation breaks 
	@Test
	public void validateSnakecase2() {
		
		Animal animbrear = new Animal();
		animbrear.setId(1);
		animbrear.setName("Snake");
		animbrear.setType(AnimalType.REPTILE.getNumVal());
		
		
		Animal animlion = new Animal();
		animlion.setId(2);
		animlion.setName("loin");
		animlion.setType(AnimalType.MAMMAL.getNumVal());
		
		
		Area a = new Area();
		a.setId(1);
		a.setName("area 1");
		Set<Pen> pset = new HashSet<>();
		a.setPens(pset);
		Pen p = new  Pen();
		p.setArea(a);
		p.setId(1);
		p.setName("pen1");
		p.setSerialNo(0);
		
		pset.add(p);
		
		Pen p2 = new  Pen();
		p2.setArea(a);
		p2.setId(2);
		p2.setName("pen2");
		p2.setSerialNo(1);
		
		pset.add(p2);
		
		Pen p3 = new  Pen();
		p3.setArea(a);
		p3.setId(3);
		p3.setName("pen3");
		p3.setSerialNo(2);
		
		pset.add(p3);
		
		Stock sbear = new Stock();
		sbear.setAnimal(animbrear);
		sbear.setId(1);
		sbear.setPen(p);
		p.setStock(sbear);
		
		Stock sbird = new Stock();
		sbird.setAnimal(animlion);
		
		assertTrue(v.validate(sbird, p2));
		
	}
	
}
