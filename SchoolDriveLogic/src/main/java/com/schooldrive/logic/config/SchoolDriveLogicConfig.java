package com.schooldrive.logic.config;

import com.schooldrive.persistence.car.CarDAO;
import com.schooldrive.persistence.car.CarDAOImpl;
import com.schooldrive.persistence.user.UserDAO;
import com.schooldrive.persistence.user.UserDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Filip on 04.10.2017.
 */
@Configuration
@ComponentScan("com")
public class SchoolDriveLogicConfig {

//    public CarDAO getCarDAO() {
//        return new CarDAOImpl();
//    }
//    public UserDAO getUserDAO() {
//        return new UserDAOImpl();
//    }

}
