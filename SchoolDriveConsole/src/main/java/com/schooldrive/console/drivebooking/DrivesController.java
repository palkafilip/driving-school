package com.schooldrive.console.drivebooking;

import com.schooldrive.logic.car.CarServiceException;
import com.schooldrive.logic.drivebooking.DriveBookingPresentation;
import com.schooldrive.logic.drivebooking.DriveBookingRequest;
import com.schooldrive.logic.drivebooking.DriveBookingService;
import com.schooldrive.logic.drivebooking.DriveBookingServiceException;
import com.schooldrive.logic.hoursinterval.HoursIntervalPresentation;
import com.schooldrive.logic.user.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ResponseEntity<?> getByUserId(@PathVariable Integer userId) throws CarServiceException {

        List<DriveBookingPresentation> drivesList = driveBookingService
                .getAllByUserId(userId)
                .stream()
                .map(driveBooking -> new DriveBookingPresentation(driveBooking))
                .collect(Collectors.toList());

        return new ResponseEntity<>(drivesList, HttpStatus.OK);
    }
    @RequestMapping(value = "/drive/{driveId}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Integer driveId) {

        DriveBookingPresentation driveBookingPresentation = new DriveBookingPresentation(driveBookingService
                .getById(driveId));

        return new ResponseEntity<>(driveBookingPresentation, HttpStatus.OK);
    }

    @RequestMapping(value = "/drive/{driveId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDrive(@PathVariable Integer driveId) {

        driveBookingService.deleteDriveBook(driveId);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/reserved", method = RequestMethod.GET)
    public ResponseEntity<?> getReservedHoursInDay(@RequestParam Integer instructorId,
                                                               @RequestParam Integer carId,
                                                               @RequestParam String day) throws CarServiceException, ParseException {

        List<HoursIntervalPresentation> takenHours = driveBookingService
                .getTakenHoursInDay(instructorId,carId,day)
                .stream()
                .map(hi -> new HoursIntervalPresentation(hi))
                .collect(Collectors.toList());

        return new ResponseEntity<>(takenHours, HttpStatus.OK);
    }

    @RequestMapping(value = "/new/book", method = RequestMethod.POST)
    public ResponseEntity<?> bookDrive(@RequestBody DriveBookingPresentation newDrive) throws ParseException, UserServiceException, CarServiceException, DriveBookingServiceException {

        DriveBookingPresentation bookConfirmation =
                new DriveBookingPresentation(driveBookingService.bookDrive(newDrive));

        return new ResponseEntity<>(bookConfirmation, HttpStatus.OK);
    }

}
