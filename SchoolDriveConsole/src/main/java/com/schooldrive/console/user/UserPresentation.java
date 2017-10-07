package com.schooldrive.console.user;

import com.schooldrive.persistence.user.User;

/**
 * Created by Filip on 07.10.2017.
 */
public class UserPresentation {

    private Integer id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public UserPresentation(User user) {

        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.phone = user.getPhone();
        this.email = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
