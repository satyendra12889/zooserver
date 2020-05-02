
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
import com.satyendra.iris.zoo.model.Pen;

@Repository
public class AnimalDao implements IAnimalDao {

    @Autowired
    private SessionFactory sessionfactory;

    @Autowired
    private DaoHelper daoHelper;

    @Override
    public int addAnimal(Animal animal) {
        daoHelper.persist(sessionfactory, animal);
        return animal.id;
    }

    @Override
    public Animal getAnimals(int id) {
        Session s = sessionfactory.getCurrentSession();
        Criteria cr = s.createCriteria(Animal.class);
        List results = cr.list();
        return (Animal) results.get(0);
    }

    @Override
    public List<Animal> getAnimalInZoo(int penId) {

        Session s = sessionfactory.getCurrentSession();
        Criteria criteria = s.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("pen.id", penId));
        return criteria.list();

    }

}
