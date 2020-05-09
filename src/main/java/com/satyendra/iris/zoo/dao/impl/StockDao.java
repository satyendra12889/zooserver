package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IStockDao;
import com.satyendra.iris.zoo.model.Stock;

@Repository
public class StockDao implements IStockDao {

	@Autowired
	DaoHelper daoHelper; 

	@PersistenceContext
	private EntityManager em;

	@Override
	public int add(Stock s) {
		daoHelper.persist(em, s);
		return s.getId();
	}

	@Override
	public List<Stock> list() {
		return null;
	}

	@Override
	public Stock get(int stockId) {
		
		em.getTransaction().begin();

		Stock stock = em.find(Stock.class, stockId);
		em.getTransaction().commit();
		return stock;
	}

	@Override
	public void update(Stock s) {
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
	}

}
