package com.schooldrive.persistence.instructorbreak;

import com.schooldrive.persistence.hoursinterval.HoursInterval;
import com.schooldrive.persistence.instructor.Instructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Filip on 16.12.2017.
 */
@Entity
@Table(name = "instructor_break")
public class InstructorBreak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_break_id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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
        return "InstructorBreak{" +
                "id=" + id +
                ", instructor=" + instructor +
                ", hoursInterval=" + hoursInterval +
                ", day=" + day +
                '}';
    }
}
