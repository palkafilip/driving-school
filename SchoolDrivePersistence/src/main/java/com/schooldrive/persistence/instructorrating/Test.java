package com.schooldrive.persistence.instructorrating;

import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.instructor.InstructorDAO;
import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by Filip on 02.10.2017.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        InstructorRatingDAO instructorRatingDAO = context.getBean(InstructorRatingDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        InstructorDAO instructorDAO = context.getBean(InstructorDAO.class);

        Instructor instructor = instructorDAO.getInstructorById(2);
        User user = userDAO.getUserById(1);

        InstructorRating ir = new InstructorRating();
        ir.setUser(user);
        ir.setInstructor(instructor);
        ir.setComment("super koleżśćłóka");
        ir.setDate(new Date());
        ir.setRate(5);

        instructorRatingDAO.addInstructorRating(ir);
    }
}
