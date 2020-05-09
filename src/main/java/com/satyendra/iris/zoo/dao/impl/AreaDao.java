package com.satyendra.iris.zoo.dao.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyendra.iris.zoo.dao.IAreaDao;
import com.satyendra.iris.zoo.model.Area;

@Repository
public class AreaDao implements IAreaDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addArea(Area area) {
        daoHelper.persist(emf, area);
        return area.id;
    }

    @Override
    public Area getArea(int id) {
        //        Session s = sessionfactory.getCurrentSession();
        //        Criteria criteria = s.createCriteria(Area.class);
        //        criteria.add(Restrictions.eq("id", id));
        //        return (Area) criteria.list().get(0);
        return null;
    }

    @Override
    public List<Area> list() {
        //        Session s = sessionfactory.getCurrentSession();
        //        Criteria criteria = s.createCriteria(Area.class);
        //        return criteria.list();
        return null;
    }

}
