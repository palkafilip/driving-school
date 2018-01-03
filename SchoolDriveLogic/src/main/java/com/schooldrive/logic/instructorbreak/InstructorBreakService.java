package com.schooldrive.logic.instructorbreak;

import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.instructorbreak.InstructorBreak;
import com.schooldrive.persistence.instructorbreak.InstructorBreakDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Filip on 16.12.2017.
 */
@Service
public class InstructorBreakService {

    InstructorBreakDAO instructorBreakDAO;

    @Autowired
    public InstructorBreakService(InstructorBreakDAO instructorBreakDAO) {
        this.instructorBreakDAO = instructorBreakDAO;
    }

    public List<InstructorBreak> getInstructorBreakByInstructorAndDay(Integer instructorId, String day) throws ParseException {
        Date dateDay = DateUtils.dateWithoutTime().parse(day);

        return instructorBreakDAO
                .getInstruktorBreakByIntructorAndDay(instructorId, dateDay);
    }
}
