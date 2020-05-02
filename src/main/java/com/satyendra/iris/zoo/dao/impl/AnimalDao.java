package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.model.Animal;
import com.satyendra.iris.zoo.model.Zoo;
@Repository
public class AnimalDao implements IAnimalDao {
	
	@Autowired
    private SessionFactory sessionfactory;
	
	@Override 
	public int addAnimal(Animal animal) {
		
		Session s = sessionfactory.getCurrentSession();
		s.save(animal);
		return animal.id;
	}

	@Override
	public Animal getAnimals(int id) {
		Session s = sessionfactory.getCurrentSession();
		Criteria cr = s.createCriteria(Animal.class);
		List results = cr.list();
		return (Animal)results.get(0);
	}

	@Override
	public List<Animal> getAnimalInZoo(int zooId) {
		
		Session s = sessionfactory.getCurrentSession();
		Criteria criteria = s.createCriteria(Animal.class);
		criteria.createAlias("pen", "p");
		criteria.createAlias("p.zoo", "z");
		
		criteria.add(Restrictions.eq("z.id", zooId));
		return  criteria.list(); 

		
	}
	
	

}
