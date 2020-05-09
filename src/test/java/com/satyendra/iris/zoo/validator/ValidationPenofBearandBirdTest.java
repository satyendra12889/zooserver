package com.satyendra.iris.zoo.validator;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidationPenofBearandBirdTest {
	
	
	
	
	// test case  bear is beside bird validation breaks 
//	@Test
//	public void validatecase1() {
//		Validator v = ZooAnimalValidation.getValidator();
//		
//		Animal animbrear = new Animal();
//		animbrear.setId(1);
//		animbrear.setName("polar bear");
//		animbrear.setType(AnimalType.MAMMAL.getNumVal());
//		
//		
//		Animal animbreard = new Animal();
//		animbreard.setId(2);
//		animbreard.setName("bird");
//		animbreard.setType(AnimalType.BIRDFLY.getNumVal());
//		
//		
//		Area a = new Area();
//		a.setId(1);
//		a.setName("area 1");
//		Set<Pen> pset = new HashSet<>();
//		a.setPens(pset);
//		Pen p = new  Pen();
//		p.setArea(a);
//		p.setId(1);
//		p.setName("pen1");
//		p.setSerialNo(0);
//		
//		
//		pset.add(p);
//		
//		Pen p2 = new  Pen();
//		p2.setArea(a);
//		p2.setId(2);
//		p2.setName("pen2");
//		p2.setSerialNo(1);
//		
//		pset.add(p2);
//		
//		Pen p3 = new  Pen();
//		p3.setArea(a);
//		p3.setId(3);
//		p3.setName("pen3");
//		p3.setSerialNo(2);
//		
//		pset.add(p3);
//		
//		//animalDao.getAnimals(animalId);
//		Stock sbear = new Stock();
//		sbear.setAnimal(animbrear);
//		sbear.setId(1);
//		sbear.setPen(p);
//		p.setStock(sbear);
//		
//		Stock sbird = new Stock();
//		sbird.setAnimal(animbreard);
//		
//		
//		
//		
//		assertFalse(v.validate(sbird, p2));
//		
//	}
//	
//	// test case  bear is beside bird validation breaks 
//	@Test
//	public void validatecase2() {
//		Validator v = ZooAnimalValidation.getValidator();
//		
//		Animal animbrear = new Animal();
//		animbrear.setId(1);
//		animbrear.setName("polar bear");
//		animbrear.setType(AnimalType.MAMMAL.getNumVal());
//		
//		
//		Animal animlion = new Animal();
//		animlion.setId(2);
//		animlion.setName("loin");
//		animlion.setType(AnimalType.MAMMAL.getNumVal());
//		
//		
//		Area a = new Area();
//		a.setId(1);
//		a.setName("area 1");
//		Set<Pen> pset = new HashSet<>();
//		a.setPens(pset);
//		Pen p = new  Pen();
//		p.setArea(a);
//		p.setId(1);
//		p.setName("pen1");
//		p.setSerialNo(0);
//		
//		
//		pset.add(p);
//		
//		Pen p2 = new  Pen();
//		p2.setArea(a);
//		p2.setId(2);
//		p2.setName("pen2");
//		p2.setSerialNo(1);
//		
//		pset.add(p2);
//		
//		Pen p3 = new  Pen();
//		p3.setArea(a);
//		p3.setId(3);
//		p3.setName("pen3");
//		p3.setSerialNo(2);
//		
//		pset.add(p3);
//		
//		//animalDao.getAnimals(animalId);
//		Stock sbear = new Stock();
//		sbear.setAnimal(animbrear);
//		sbear.setId(1);
//		sbear.setPen(p);
//		p.setStock(sbear);
//		
//		Stock sbird = new Stock();
//		sbird.setAnimal(animlion);
//		
//		
//		
//		
//		assertTrue(v.validate(sbird, p2));
//		
//	}

}
