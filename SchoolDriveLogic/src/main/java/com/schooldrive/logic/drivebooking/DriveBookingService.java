package com.schooldrive.logic.drivebooking;

import com.schooldrive.logic.hoursinterval.HoursIntervalPresentation;
import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.drivebooking.DriveBookingDAO;
import com.schooldrive.persistence.hoursinterval.HoursInterval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 30.11.2017.
 */
@Service
public class DriveBookingService {
    DriveBookingDAO driveBookingDAO;

    @Autowired
    public DriveBookingService(DriveBookingDAO driveBookingDAO) {
        this.driveBookingDAO = driveBookingDAO;
    }

    public List<DriveBooking> getAllByUserId(Integer id) {
        return this.driveBookingDAO.getAllDrivesByUserId(id);
    }

    public List<HoursInterval> getTakenHoursInDay(Integer instructorId, Integer carId, String day) throws ParseException {
        Date dateDay = DateUtils.dateWithoutTime().parse(day);
        return driveBookingDAO
                .getTakenHoursInDayByInstructorCarDay(instructorId, carId, dateDay)
                .stream()
                .map(db -> db.getHoursInterval())
                .collect(Collectors.toList());
    }
}
