package com.schooldrive.persistence.instructorrating;

import java.util.List;

/**
 * Created by Filip on 02.10.2017.
 */
public interface InstructorRatingDAO {

    void addInstructorRating(InstructorRating instructorRating);
    List<InstructorRating> getByInstructorId(Integer instructorId);
    InstructorRating getByIntructorAndUser(Integer instructorId, Integer userId);
}
