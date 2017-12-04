package com.schooldrive.logic.instructor;

import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.instructor.InstructorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Filip on 12.10.2017.
 */
@Service
public class InstructorService {

    InstructorDAO instructorDAO;

    @Autowired
    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    public List<Instructor> getAllInstructors() {
        return instructorDAO.getAllInstructors();
    }
}
