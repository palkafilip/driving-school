package com.schooldrive.logic.user;

import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Filip on 06.10.2017.
 */
@Service
public class UserService {

    private UserDAO userDAO;

    public UserService() {}

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUserById(Integer id) {
        return userDAO.getUserById(id);
    }
}
