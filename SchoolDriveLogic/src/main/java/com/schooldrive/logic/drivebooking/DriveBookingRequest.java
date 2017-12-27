package com.schooldrive.logic.drivebooking;

/**
 * Created by Filip on 22.12.2017.
 */
public class DriveBookingRequest {
    private Integer userId;
    private Integer instructorId;
    private Integer carId;
    private Integer hoursIntervalId;
    private String day;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getHoursIntervalId() {
        return hoursIntervalId;
    }

    public void setHoursIntervalId(Integer hoursIntervalId) {
        this.hoursIntervalId = hoursIntervalId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
