package com.schooldrive.persistence.drivebooking;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.car.CarDAO;
import com.schooldrive.persistence.carrating.CarRating;
import com.schooldrive.persistence.carrating.CarRatingDAO;
import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.instructor.InstructorDAO;
import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by Filip on 04.10.2017.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        DriveBookingDAO driveBookingDAO = context.getBean(DriveBookingDAO.class);
        CarDAO carDAO = context.getBean(CarDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        InstructorDAO instructorDAO = context.getBean(InstructorDAO.class);

        Instructor instructor = instructorDAO.getInstructorById(2);
        User user = userDAO.getUserById(1);
        Car car = carDAO.getCarById(5);

        DriveBooking driveBooking = new DriveBooking();
        driveBooking.setCar(car);
        driveBooking.setUser(user);
        driveBooking.setInstructor(instructor);
        driveBooking.setDay(new Date());
        driveBooking.setStartTime("10:25:00");
        driveBooking.setEndTime("15:00:00");

        driveBookingDAO.addDriveBooking(driveBooking);


    }
}
