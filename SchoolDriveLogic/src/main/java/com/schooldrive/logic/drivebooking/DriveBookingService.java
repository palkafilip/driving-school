package com.schooldrive.logic.drivebooking;

import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.drivebooking.DriveBookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
