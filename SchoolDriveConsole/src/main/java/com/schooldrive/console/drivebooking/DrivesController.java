package com.schooldrive.console.drivebooking;

import com.schooldrive.logic.car.CarServiceException;
import com.schooldrive.logic.drivebooking.DriveBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 21.11.2017.
 */
@RestController
@RequestMapping("rest/drives")
public class DrivesController {

    DriveBookingService driveBookingService;

    @Autowired
    public DrivesController(DriveBookingService driveBookingService) {
        this.driveBookingService = driveBookingService;
    }

    @RequestMapping(value = "/{userId}/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@PathVariable Integer userId) throws CarServiceException {

        List<DriveBookingPresentation> drivesList = driveBookingService
                .getAllByUserId(userId)
                .stream()
                .map(driveBooking -> new DriveBookingPresentation(driveBooking))
                .collect(Collectors.toList());

        return new ResponseEntity<>(drivesList, HttpStatus.OK);
    }


}
