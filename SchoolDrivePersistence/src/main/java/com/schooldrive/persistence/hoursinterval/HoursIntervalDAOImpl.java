package com.schooldrive.persistence.hoursinterval;

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
public class HoursIntervalDAOImpl implements HoursIntervalDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public HoursInterval getHoursIntervalById(Integer id) {
        return em.find(HoursInterval.class, id);
    }

    @Override
    public List<HoursInterval> getAllHourIntervals() {
        String jpqlQuery = "SELECT hi from HoursInterval hi";
        TypedQuery<HoursInterval> query = em.createQuery(jpqlQuery, HoursInterval.class);
        return query.getResultList();
    }
}
