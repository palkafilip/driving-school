package com.schooldrive.persistence.instructor;

/**
 * Created by Filip on 02.10.2017.
 */

public interface InstructorDAO {

    void addInstructor(Instructor instructor);
    Instructor getInstructorById(Integer id);
}
