package com.schooldrive.persistence.drivebooking;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.hoursinterval.HoursInterval;
import com.schooldrive.persistence.instructor.Instructor;
import com.schooldrive.persistence.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Filip on 21.09.2017.
 */
@Entity
@Table(name = "drive_booking")
public class DriveBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hours_interval_id")
    private HoursInterval hoursInterval;

    @Column(name = "day", nullable = false)
    private Date day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public HoursInterval getHoursInterval() {
        return hoursInterval;
    }

    public void setHoursInterval(HoursInterval hoursInterval) {
        this.hoursInterval = hoursInterval;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "DriveBooking{" +
                "id=" + id +
                ", user=" + user +
                ", instructor=" + instructor +
                ", car=" + car +
                ", hoursInterval=" + hoursInterval +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriveBooking that = (DriveBooking) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return day != null ? day.equals(that.day) : that.day == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }
}
