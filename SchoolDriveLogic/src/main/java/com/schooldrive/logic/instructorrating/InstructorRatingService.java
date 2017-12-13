package com.schooldrive.logic.instructorrating;

import com.schooldrive.persistence.instructorrating.InstructorRating;
import com.schooldrive.persistence.instructorrating.InstructorRatingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Filip on 12.10.2017.
 */
@Service
public class InstructorRatingService {

    InstructorRatingDAO instructorRatingDAO;

    @Autowired
    public InstructorRatingService(InstructorRatingDAO instructorRatingDAO) {
        this.instructorRatingDAO = instructorRatingDAO;
    }

    public List<InstructorRating> getByInstructorId(Integer id) {
        return instructorRatingDAO.getByInstructorId(id);
    }
}
