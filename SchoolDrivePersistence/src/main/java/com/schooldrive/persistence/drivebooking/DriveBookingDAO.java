package com.schooldrive.persistence.drivebooking;

import java.util.Date;
import java.util.List;

/**
 * Created by Filip on 04.10.2017.
 */
public interface DriveBookingDAO {

    void addDriveBooking(DriveBooking driveBooking);
    List<DriveBooking> getAllDrivesByUserId(Integer id);
    List<DriveBooking> getTakenHoursInDayByInstructorCarDay(Integer instructorId, Integer carId, Date day);
}
