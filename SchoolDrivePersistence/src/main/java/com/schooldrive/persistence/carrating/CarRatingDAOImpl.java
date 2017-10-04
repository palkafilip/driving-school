package com.schooldrive.persistence.carrating;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Filip on 01.10.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class CarRatingDAOImpl implements CarRatingDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void addCarRating(CarRating carRating) {
        em.merge(carRating);
    }

    @Override
    public CarRating getCarRatingById(Integer id) {
       return em.find(CarRating.class, id);
    }

}
