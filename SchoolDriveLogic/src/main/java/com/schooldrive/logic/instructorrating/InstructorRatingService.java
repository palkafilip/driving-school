package com.schooldrive.logic.instructorrating;

import com.schooldrive.logic.instructor.InstructorService;
import com.schooldrive.logic.user.UserService;
import com.schooldrive.logic.user.UserServiceException;
import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.instructorrating.InstructorRating;
import com.schooldrive.persistence.instructorrating.InstructorRatingDAO;
import com.schooldrive.persistence.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Filip on 12.10.2017.
 */
@Service
public class InstructorRatingService {

    InstructorRatingDAO instructorRatingDAO;
    InstructorService instructorService;
    UserService userService;

    @Autowired
    public InstructorRatingService(InstructorRatingDAO instructorRatingDAO, InstructorService instructorService, UserService userService) {
        this.instructorRatingDAO = instructorRatingDAO;
        this.instructorService = instructorService;
        this.userService = userService;
    }

    public List<InstructorRating> getByInstructorId(Integer id) {
        return instructorRatingDAO.getByInstructorId(id);
    }

    public InstructorRating getByInstructorAndUser(Integer instructorId, Integer userId) {
        return this.instructorRatingDAO.getByIntructorAndUser(instructorId, userId);
    }

    public void addInstructorRating(InstructorRatingPresentation rating) throws UserServiceException, ParseException {
        InstructorRating instructorRating = convertToInstructorRating(rating);

        instructorRatingDAO.addInstructorRating(instructorRating);
    }

    private InstructorRating convertToInstructorRating(InstructorRatingPresentation ratingPresentation) throws UserServiceException, ParseException {
        InstructorRating instructorRating = new InstructorRating();
        Instructor instructor = instructorService.getById(ratingPresentation.getInstructor().getId());
        User user = userService.getUserById(ratingPresentation.getUser().getId());
        Date date = DateUtils.dateWithoutTime().parse(ratingPresentation.getDate());

        instructorRating.setUser(user);
        instructorRating.setInstructor(instructor);
        instructorRating.setRate(ratingPresentation.getRate());
        instructorRating.setComment(ratingPresentation.getComment());
        instructorRating.setDate(date);

        return instructorRating;
    }
}
