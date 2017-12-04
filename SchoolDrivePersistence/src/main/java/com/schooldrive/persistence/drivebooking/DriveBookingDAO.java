package com.schooldrive.persistence.drivebooking;

import java.util.List;

/**
 * Created by Filip on 04.10.2017.
 */
public interface DriveBookingDAO {

    void addDriveBooking(DriveBooking driveBooking);
    List<DriveBooking> getAllDrivesByUserId(Integer id);
}
