package com.schooldrive.persistence.carrating;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.car.CarDAO;
import com.schooldrive.persistence.car.CarDAOImpl;
import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import com.schooldrive.persistence.user.UserDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by Filip on 01.10.2017.
 */
public class Test {



    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        CarRatingDAO carRatingDAO = context.getBean(CarRatingDAO.class);
        CarDAO carDAO = context.getBean(CarDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);

        CarRating carRating = new CarRating();
//        System.out.println(carDAO.getCarById(1));
//        System.out.println(userDAO.getUserById(1));
        Car car = carDAO.getCarById(5);
        carRating.setCar(car);
        carRating.setComment("waaaaaaaaaaaaaaaaaaaaaaaaat");
        carRating.setDate(new Date());
        carRating.setRate(2);
        User user = userDAO.getUserById(1);
        carRating.setUser(user);

        System.out.println(carRatingDAO.getCarRatingById(1));
    }
}
