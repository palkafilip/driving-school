package com.schooldrive.persistence.hoursinterval;

import com.schooldrive.persistence.carrating.CarRating;
import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.instructorbreak.InstructorBreak;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip on 16.12.2017.
 */
@Entity
@Table(name = "hours_interval")
public class HoursInterval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hours_interval_id", nullable = false)
    private Integer id;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @OneToMany(mappedBy = "hoursInterval")
    private Set<DriveBooking> driveBookings = new HashSet<>();

    @OneToMany(mappedBy = "hoursInterval")
    private Set<InstructorBreak> instructorBreaks = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<DriveBooking> getDriveBookings() {
        return driveBookings;
    }

    public void setDriveBookings(Set<DriveBooking> driveBookings) {
        this.driveBookings = driveBookings;
    }

    public Set<InstructorBreak> getInstructorBreaks() {
        return instructorBreaks;
    }

    public void setInstructorBreaks(Set<InstructorBreak> instructorBreaks) {
        this.instructorBreaks = instructorBreaks;
    }

    @Override
    public String toString() {
        return "HoursInterval{" +
                "id=" + id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoursInterval that = (HoursInterval) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        return endTime != null ? endTime.equals(that.endTime) : that.endTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
