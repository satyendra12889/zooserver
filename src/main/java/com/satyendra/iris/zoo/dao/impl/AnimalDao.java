
package com.satyendra.iris.zoo.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IAnimalDao;
import com.satyendra.iris.zoo.model.Animal;

@Repository
public class AnimalDao implements IAnimalDao {

    
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addAnimal(Animal animal) {
        daoHelper.persist(emf, animal);
        return animal.id;
    }

    @Override
    public Animal getAnimals(int id) {
//        Session s = em.getCurrentSession();
//        EntityManager em = emf.createEntityManager();
//    	CriteriaBuilder cb = em.getCriteriaBuilder();
//    	CriteriaQuery<Animal> cq=cb.createQuery(Animal.class);
//    	Root<Animal> stud=cq.from(Animal.class);
////    	Root<Animal> animal = cq.from(Animal_);
//    	cq.where(cb.equal(stud.get("id"),id));
//    	
//    	CriteriaQuery<Animal> select = cq.select(stud);
//    	Query q = em.createQuery(select);  
//    	List<Animal> list = q.getResultList();
//    	Criteria cr = em.getCriteriaBuilder()(Animal.class);
//    	
//        cr.add(Restrictions.eq("id", id));
//        List results = cr.list();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Animal> query = em.createQuery("SELECT a from Animal a where a.id = :id", Animal.class);
        query.setParameter("id", id);
        List<Animal> result = query.getResultList();
        return result.get(0);
    }

    @Override
    public List<Animal> getAnimalInArea(int areaId) {

//        Session s = sessionfactory.getCurrentSession();
//        Criteria criteria = s.createCriteria(Animal.class);
//		criteria.createAlias("pen", "p");
//		criteria.createAlias("p.area", "z");
//		criteria.add(Restrictions.eq("z.id", areaId));
//		return criteria.list();
    	return null;

    }

    @Override
    public List<Animal> getAllAnimals() {
//        Session s = sessionfactory.getCurrentSession();
//        Criteria cr = s.createCriteria(Animal.class);
//        List results = cr.list();
//        return results;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a",Animal.class);
        List<Animal> result = query.getResultList();
    	return result;
    }

	@Override
	public List<Animal> getAllAnimals(int animalType, int areaId, int penId) {
		// TODO Auto-generated method stub
//		Session s = sessionfactory.getCurrentSession();
//        Criteria criteria = s.createCriteria(Animal.class);
//		
//		
//		if(animaltype>0) {
//			
//			criteria.add(Restrictions.eq("type", animaltype));
//		}
//		if(areaId >0) {
//			criteria.createAlias("stock", "p");
//			criteria.createAlias("p.pen", "z");
//			criteria.createAlias("z.area", "a");
//			criteria.add(Restrictions.eq("a.id", areaId));
//		}
//		if(penId > 0) {
//			criteria.add(Restrictions.eq("z.id", penId));
//		}
//		
//		return criteria.list();
	    EntityManager em = emf.createEntityManager();
	    String sqlQuery1 = "SELECT a from ANIMAL a  left join STOCK s on a.id = s.animal_id left join PEN p on s.pen_id = p.id" ;
	    if(areaId >0 || penId >0) {
	        sqlQuery1 += "where ";
	    }
	    if(areaId >0) {
	        sqlQuery1 += "a.type=:animalType ";
	    }
	    
	    if(penId > 0) {
	        if(areaId >0) {
	            sqlQuery1 += "and ";
	        }
	        sqlQuery1 += "p. id = :penId and p.area_id = :areaId ";
	    }
	    
	    TypedQuery<Animal> query1  = em.createQuery(sqlQuery1,Animal.class);
	    query1.setParameter("animalType", animalType);
	    query1.setParameter("penId", penId);
        query1.setParameter("areaId", areaId);
//        List<Collection> l = query1.getResultList();
//        
//	    String sqlQuery = "SELECT a from ANIMAL a JOIN STOCK s on a JOIN PEN p where a.TYPE = :animalType and p.ID = :penId and p.AREA_ID = :penAreaId";
//	    TypedQuery<Animal> query  = em.createQuery(sqlQuery,Animal.class);
//	    query.setParameter("animalType", animalType);
//	    
	    List<Animal> result = query1.getResultList();
	    
		return result;
	}
}
