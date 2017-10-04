package com.schooldrive.persistence.instructor;

import com.schooldrive.persistence.config.SchoolDrivePersistenceContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Filip on 21.09.2017.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SchoolDrivePersistenceContext.class);

        InstructorDAO instr = context.getBean(InstructorDAO.class);

        Instructor i = new Instructor();
        i.setFirstname("Gosc");
        i.setLastname("Ktos");
        i.setEmail("filip.palka@poczta.pl");
        i.setPhone("111222333");

        instr.addInstructor(i);


    }
}
