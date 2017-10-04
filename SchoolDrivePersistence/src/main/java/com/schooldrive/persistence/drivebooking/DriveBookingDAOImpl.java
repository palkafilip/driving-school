package com.schooldrive.persistence.drivebooking;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Filip on 04.10.2017.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)
public class DriveBookingDAOImpl implements DriveBookingDAO {

    @PersistenceContext
    protected EntityManager em;

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public void addDriveBooking(DriveBooking driveBooking) {
        em.merge(driveBooking);
    }
}
