package com.schooldrive.persistence.car;

import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Filip on 22.09.2017.
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        CarDAO carDAO = context.getBean(CarDAO.class);
        Car car = new Car();

        car.setBrand("Reno");
        car.setModel("Megan");
        car.setEngineCapacity(2500);
        car.setFuelType("Disel");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        car.setYear(sdf.parse("2017-01-03"));
        carDAO.addCar(car);

        System.out.println(carDAO.getCarById(1));


    }

}
