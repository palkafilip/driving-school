package com.schooldrive.persistence.instructorrating;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<InstructorRating> getByInstructorId(Integer instructorId) {
        String jpqlQuery = "SELECT ir from InstructorRating ir where ir.instructor.id = :iid";
        TypedQuery<InstructorRating> query = em.createQuery(jpqlQuery, InstructorRating.class);
        query.setParameter("iid", instructorId);
        return query.getResultList();
    }

    @Override
    public InstructorRating getByIntructorAndUser(Integer instructorId, Integer userId) {
        String jpqlQuery = "SELECT ir from InstructorRating ir where ir.instructor.id = :iid and ir.user.id = :uid";
        TypedQuery<InstructorRating> query = em.createQuery(jpqlQuery, InstructorRating.class);
        query.setParameter("iid", instructorId);
        query.setParameter("uid", userId);
//        return query.getSingleResult();
        List<InstructorRating> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }
}
