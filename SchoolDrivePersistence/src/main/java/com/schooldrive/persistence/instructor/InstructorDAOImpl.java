package com.schooldrive.persistence.instructor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Filip on 21.09.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class InstructorDAOImpl implements InstructorDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Transactional
    public void addInstructor(Instructor instructor) {
        em.persist(instructor);
    }

    public Instructor getInstructorById(Integer id) {
        return em.find(Instructor.class, id);
    }
}
