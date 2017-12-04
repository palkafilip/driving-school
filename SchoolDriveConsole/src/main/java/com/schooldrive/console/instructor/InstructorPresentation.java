package com.schooldrive.console.instructor;

import com.schooldrive.persistence.instructor.Instructor;

/**
 * Created by Filip on 02.12.2017.
 */
public class InstructorPresentation {

    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public InstructorPresentation(Instructor instructor) {
        this.id = instructor.getId();
        this.firstname = instructor.getFirstname();
        this.lastname = instructor.getLastname();
        this.phone = instructor.getPhone();
        this.email = instructor.getEmail();
    }

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
}
