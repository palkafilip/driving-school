package com.schooldrive.persistence.car;

/**
 * Created by Filip on 22.09.2017.
 */

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class CarDAOImpl implements CarDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void addCar(Car car) {
        em.persist(car);
    }

    public Car getCarById(Integer id) {
       return em.find(Car.class, id);
    }
}
