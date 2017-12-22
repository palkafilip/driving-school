package com.schooldrive.persistence.drivebooking;

import com.schooldrive.persistence.car.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<DriveBooking> getAllDrivesByUserId(Integer userId) {
        String jpqlQuery = "SELECT db from DriveBooking db where db.user.id = :uid";
        TypedQuery<DriveBooking> query = em.createQuery(jpqlQuery, DriveBooking.class);
        query.setParameter("uid", userId);
        return query.getResultList();
    }

    @Override
    public List<DriveBooking> getTakenHoursInDayByInstructorCarDay(Integer instructorId, Integer carId, Date inputDay) {
        String jpqlQuery = "SELECT db from DriveBooking db where db.instructor.id = :iid and db.car.id = :cid and db.day = :iday";
        TypedQuery<DriveBooking> query = em.createQuery(jpqlQuery, DriveBooking.class);
        query.setParameter("iid", instructorId);
        query.setParameter("cid", carId);
        query.setParameter("iday", inputDay);
        return query.getResultList();
    }
}
