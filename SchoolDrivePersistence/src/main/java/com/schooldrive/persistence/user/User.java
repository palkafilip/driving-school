package com.schooldrive.persistence.user;

import com.schooldrive.persistence.carrating.CarRating;
import com.schooldrive.persistence.drivebooking.DriveBooking;
import com.schooldrive.persistence.instructorrating.InstructorRating;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip on 21.09.2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<InstructorRating> instructorRatings = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<CarRating> carRatings = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<DriveBooking> driveBookings = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<CarRating> getCarRatings() {
        return carRatings;
    }

    public void setCarRatings(Set<CarRating> carRatings) {
        this.carRatings = carRatings;
    }

    public Set<DriveBooking> getDriveBookings() {
        return driveBookings;
    }

    public void setDriveBookings(Set<DriveBooking> driveBookings) {
        this.driveBookings = driveBookings;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
