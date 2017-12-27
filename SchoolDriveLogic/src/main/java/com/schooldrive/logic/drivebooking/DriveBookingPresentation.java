package com.schooldrive.logic.drivebooking;

import com.schooldrive.logic.car.CarPresentation;
import com.schooldrive.logic.instructor.InstructorPresentation;
import com.schooldrive.logic.hoursinterval.HoursIntervalPresentation;
import com.schooldrive.logic.user.UserPresentation;
import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.drivebooking.DriveBooking;

/**
 * Created by Filip on 02.12.2017.
 */
public class DriveBookingPresentation {

    private Integer id;
    private UserPresentation user;
    private InstructorPresentation instructor;
    private CarPresentation car;
    private HoursIntervalPresentation hoursInterval;
    private String day;

    public DriveBookingPresentation() {
    }

    public DriveBookingPresentation(DriveBooking driveBooking) {
        this.id = driveBooking.getId();
        this.user = new UserPresentation(driveBooking.getUser());
        this.instructor = new InstructorPresentation(driveBooking.getInstructor());
        this.car = new CarPresentation(driveBooking.getCar());
        this.day = DateUtils.dateWithoutTime().format(driveBooking.getDay());
        this.hoursInterval = new HoursIntervalPresentation(driveBooking.getHoursInterval());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserPresentation getUser() {
        return user;
    }

    public void setUser(UserPresentation user) {
        this.user = user;
    }

    public InstructorPresentation getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorPresentation instructor) {
        this.instructor = instructor;
    }

    public CarPresentation getCar() {
        return car;
    }

    public void setCar(CarPresentation car) {
        this.car = car;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public HoursIntervalPresentation getHoursInterval() {
        return hoursInterval;
    }

    public void setHoursInterval(HoursIntervalPresentation hoursInterval) {
        this.hoursInterval = hoursInterval;
    }
}
