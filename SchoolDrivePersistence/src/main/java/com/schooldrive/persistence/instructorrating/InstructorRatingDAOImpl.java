package com.schooldrive.persistence.instructorrating;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Filip on 02.10.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class InstructorRatingDAOImpl implements InstructorRatingDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void addInstructorRating(InstructorRating instructorRating) {
        em.merge(instructorRating);
    }
}
