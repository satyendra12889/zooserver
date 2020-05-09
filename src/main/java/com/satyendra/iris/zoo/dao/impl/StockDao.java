package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IStockDao;
import com.satyendra.iris.zoo.model.Area;
import com.satyendra.iris.zoo.model.Stock;

@Repository
public class StockDao implements IStockDao {

	@Autowired
	DaoHelper daoHelper; 

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public int add(Stock s) {
		daoHelper.persist(emf, s);
		return s.getId();
	}

	@Override
	public List<Stock> list() {
		return null;
	}

	@Override
	public Stock get(int stockId) {
//	    EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//
//		Stock stock = em.find(Stock.class, stockId);
//		em.getTransaction().commit();
//		return stock;
		EntityManager em = emf.createEntityManager();
        TypedQuery<Stock> query = em.createQuery("SELECT s from Stock s where s.id = :id", Stock.class);
        query.setParameter("id", stockId);
        List<Stock> result = query.getResultList();
        return result.get(0);
	}

	@Override
	public void update(Stock s) {
	    EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
	}

}
