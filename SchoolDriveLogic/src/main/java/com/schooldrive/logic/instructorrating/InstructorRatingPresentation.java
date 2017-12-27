package com.schooldrive.logic.instructorrating;

import com.schooldrive.logic.instructor.InstructorPresentation;
import com.schooldrive.logic.user.UserPresentation;
import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.instructorrating.InstructorRating;

/**
 * Created by Filip on 04.12.2017.
 */
public class InstructorRatingPresentation {

    private Integer id;
    private UserPresentation user;
    private InstructorPresentation instructor;
    private String comment;
    private Integer rate;
    private String date;

    public InstructorRatingPresentation() {
    }

    public InstructorRatingPresentation(InstructorRating instructorRating) {
        this.id = instructorRating.getId();
        this.user = new UserPresentation(instructorRating.getUser());
        this.instructor = new InstructorPresentation(instructorRating.getInstructor());
        this.comment = instructorRating.getComment();
        this.rate = instructorRating.getRate();
        this.date = DateUtils.dateWithTime().format(instructorRating.getDate());
    }

    public Integer getId() {
        return id;
    }

    public UserPresentation getUser() {
        return user;
    }

    public InstructorPresentation getInstructor() {
        return instructor;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }
}
