package com.schooldrive.console.drivebooking;

import com.schooldrive.console.car.CarPresentation;
import com.schooldrive.console.instructor.InstructorPresentation;
import com.schooldrive.console.user.UserPresentation;
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
    private String day;
    private String startTime;
    private String endTime;

    public DriveBookingPresentation(DriveBooking driveBooking) {
        this.id = driveBooking.getId();
        this.user = new UserPresentation(driveBooking.getUser());
        this.instructor = new InstructorPresentation(driveBooking.getInstructor());
        this.car = new CarPresentation(driveBooking.getCar());
        this.day = DateUtils.dateWithoutTime().format(driveBooking.getDay());
        this.startTime = driveBooking.getStartTime();
        this.endTime = driveBooking.getEndTime();
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
