package com.schooldrive.persistence.instructor;

import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.instructorrating.InstructorRating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip on 21.09.2017.
 */
@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "instructor")
    private Set<InstructorRating> instructorRatings = new HashSet<>();

    @OneToMany(mappedBy = "instructor")
    private Set<DriveBooking> driveBookings = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<InstructorRating> getInstructorRatings() {
        return instructorRatings;
    }

    public void setInstructorRatings(Set<InstructorRating> instructorRatings) {
        this.instructorRatings = instructorRatings;
    }

    public Set<DriveBooking> getDriveBookings() {
        return driveBookings;
    }

    public void setDriveBookings(Set<DriveBooking> driveBookings) {
        this.driveBookings = driveBookings;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
