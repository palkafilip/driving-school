package com.schooldrive.persistence.instructorbreak;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Filip on 16.12.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class InstructorBreakDAOImpl implements InstructorBreakDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }


    @Override
    public InstructorBreak getInstructorBreakById(Integer id) {
        return em.find(InstructorBreak.class, id);
    }

    @Override
    public List<InstructorBreak> getAllInstructorBreaksByInstructorId(Integer instructorId) {
        String jpqlQuery = "SELECT ib from InstructorBreak ib where ib.instructor.id = :iid";
        TypedQuery<InstructorBreak> query = em.createQuery(jpqlQuery, InstructorBreak.class);
        query.setParameter("iid", instructorId);
        return query.getResultList();
    }
}
