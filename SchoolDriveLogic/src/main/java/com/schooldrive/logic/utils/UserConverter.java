package com.schooldrive.logic.utils;

import com.schooldrive.logic.user.RegisterUser;
import com.schooldrive.persistence.user.User;

/**
 * Created by Filip on 24.10.2017.
 */
public class UserConverter {

    public static User convertRegisterUserToDBUser(RegisterUser registerUser) {
        User dbUser = new User();
        dbUser.setLogin(registerUser.getLogin());
        dbUser.setPassword(registerUser.getPassword());
        dbUser.setFirstname(registerUser.getFirstname());
        dbUser.setLastname(registerUser.getLastname());
        dbUser.setPhone(registerUser.getPhone());
        if(registerUser.getEmail() != null) {
            dbUser.setEmail(registerUser.getEmail());
        }

        return dbUser;
    }
}
