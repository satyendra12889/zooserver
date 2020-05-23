
package com.satyendra.iris.zoo.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.model.Animal;

@Repository
public class AnimalDao implements IAnimalDao {

    
    

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addAnimal(Animal animal) {
        daoHelper.persist(daoHelper.getEMFInstance(), animal);
        return animal.id;
    }

    @Override
    public Animal getAnimals(int id) {
        EntityManager em = daoHelper.getEMFInstance().createEntityManager();
        TypedQuery<Animal> query = em.createQuery("SELECT a from Animal a where a.id = :id", Animal.class);
        query.setParameter("id", id);
        List<Animal> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public List<Animal> getAnimalInArea(int areaId) {

    	 EntityManager em = daoHelper.getEMFInstance().createEntityManager();
 	    String sqlQuery1 = "SELECT a from Animal a  Left JOIN Stock s ON a.id = s.animal.id LEFT JOIN Pen p ON s.pen.id = p.id where  p.area.id = :areaId" ;
 	    
 	    TypedQuery<Animal> query1  = em.createQuery(sqlQuery1,Animal.class);
 	        query1.setParameter("areaId", areaId);	
 	    
 	    List<Animal> result = query1.getResultList();
 	    
 		return result;
    }

    @Override
    public List<Animal> getAllAnimals() {
        EntityManager em = daoHelper.getEMFInstance().createEntityManager();
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a",Animal.class);
        List<Animal> result = query.getResultList();
    	return result;
    }

	@Override
	public List<Animal> getAllAnimals(int animalType, int areaId, int penId) {
	    EntityManager em = daoHelper.getEMFInstance().createEntityManager();
	    String sqlQuery1 = "SELECT DISTINCT a from Animal a  Left JOIN Stock s ON a.id = s.animal.id LEFT JOIN Pen p ON s.pen.id = p.id" ;
	    if(animalType >0 || penId >0) {
	        sqlQuery1 += " where ";
	    }
	    if(animalType >0) {
	        sqlQuery1 += "a.type=:animalType ";
	    }
	    
	    if(penId > 0) {
	        if(areaId >0) {
	            sqlQuery1 += "and ";
	        }
	        sqlQuery1 += "p.id = :penId and p.area.id = :areaId ";
	    }
	    
	    TypedQuery<Animal> query1  = em.createQuery(sqlQuery1,Animal.class);
	 if(animalType>0) {
	    query1.setParameter("animalType", animalType);

	 }
	 if(penId >0) {
	    	query1.setParameter("penId", penId);
	        query1.setParameter("areaId", areaId);	
	    }
	    
	    List<Animal> result = query1.getResultList();
	    
		return result;
	}
}
