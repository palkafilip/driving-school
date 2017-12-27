package com.schooldrive.logic.drivebooking;

import com.schooldrive.logic.car.CarService;
import com.schooldrive.logic.car.CarServiceException;
import com.schooldrive.logic.hoursinterval.HoursIntervalPresentation;
import com.schooldrive.logic.hoursinterval.HoursIntervalService;
import com.schooldrive.logic.instructor.InstructorService;
import com.schooldrive.logic.user.UserService;
import com.schooldrive.logic.user.UserServiceException;
import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.drivebooking.DriveBookingDAO;
import com.schooldrive.persistence.hoursinterval.HoursInterval;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.user.User;
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
    InstructorService instructorService;
    CarService carService;
    UserService userService;
    HoursIntervalService hoursIntervalService;

    @Autowired
    public DriveBookingService(DriveBookingDAO driveBookingDAO, InstructorService instructorService, CarService carService, UserService userService, HoursIntervalService hoursIntervalService) {
        this.driveBookingDAO = driveBookingDAO;
        this.instructorService = instructorService;
        this.carService = carService;
        this.userService = userService;
        this.hoursIntervalService = hoursIntervalService;
    }

    public List<DriveBooking> getAllByUserId(Integer id) {
        return this.driveBookingDAO.getAllDrivesByUserId(id);
    }

    public DriveBooking getById(Integer id) {
        return this.driveBookingDAO.getDriveById(id);
    }

    public void deleteDriveBook(Integer id) {
        DriveBooking driveBooking = getById(id);
        driveBookingDAO.deleteBook(driveBooking);
    }

    public List<HoursInterval> getTakenHoursInDay(Integer instructorId, Integer carId, String day) throws ParseException {
        Date dateDay = DateUtils.dateWithoutTime().parse(day);
        return driveBookingDAO
                .getTakenHoursInDayByInstructorCarDay(instructorId, carId, dateDay)
                .stream()
                .map(db -> db.getHoursInterval())
                .collect(Collectors.toList());
    }

    public Boolean checkIfUserHasBook(Integer userId, Integer hoursIntervalId, String day) throws ParseException {
        Date dateDay = DateUtils.dateWithoutTime().parse(day);
        return driveBookingDAO.getBookCountByUserDayHours(userId, hoursIntervalId, dateDay) > 0;
    }

    public DriveBooking bookDrive(DriveBookingPresentation newDrive) throws ParseException, UserServiceException, CarServiceException, DriveBookingServiceException {

        if(checkIfUserHasBook(
                newDrive.getUser().getId(),
                newDrive.getHoursInterval().getId(),
                newDrive.getDay())) {
            throw new DriveBookingServiceException("Nie można mieć dwóch rezeracji w jednym terminie!");
        }

        DriveBooking driveBooking = convertToDriveBooking(newDrive);

        return this.driveBookingDAO.addDriveBooking(driveBooking);

    }

    //TODO: Obsłużyć wyjątki z innych serwisów i wyrzucić DriveBookingServiceException
    private DriveBooking convertToDriveBooking(DriveBookingPresentation driveToConvert) throws CarServiceException, UserServiceException, ParseException {
        DriveBooking driveBooking = new DriveBooking();
        Instructor instructor = instructorService.getById(driveToConvert.getInstructor().getId());
        Car car = carService.getCarById(driveToConvert.getCar().getId());
        User user = userService.getUserById(driveToConvert.getUser().getId());
        HoursInterval hoursInterval = hoursIntervalService.getHoursIntervalById(driveToConvert.getHoursInterval().getId());
        Date day = DateUtils.dateWithoutTime().parse(driveToConvert.getDay());

        driveBooking.setInstructor(instructor);
        driveBooking.setUser(user);
        driveBooking.setCar(car);
        driveBooking.setHoursInterval(hoursInterval);
        driveBooking.setDay(day);
        if(driveToConvert.getId() != null) {
            driveBooking.setId(driveToConvert.getId());
        }

        return driveBooking;
    }
}
