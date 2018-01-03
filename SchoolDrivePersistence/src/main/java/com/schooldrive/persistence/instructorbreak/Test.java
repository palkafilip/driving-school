package com.schooldrive.persistence.instructorbreak;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.car.CarDAO;
import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.drivebooking.DriveBookingDAO;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.instructor.InstructorDAO;
import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Filip on 16.12.2017.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        DriveBookingDAO driveBookingDAO = context.getBean(DriveBookingDAO.class);
        CarDAO carDAO = context.getBean(CarDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        InstructorDAO instructorDAO = context.getBean(InstructorDAO.class);
        InstructorBreakDAO instructorBreakDAO = context.getBean(InstructorBreakDAO.class);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = simpleDateFormat.parse("2017-12-17");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(instructorBreakDAO.getInstruktorBreakByIntructorAndDay(1,d));
    }
}
