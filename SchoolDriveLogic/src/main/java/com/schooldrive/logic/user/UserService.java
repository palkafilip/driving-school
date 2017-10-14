package com.schooldrive.logic.user;

import com.schooldrive.persistence.user.User;
import com.schooldrive.persistence.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User getUserById(Integer id) throws UserServiceException {
        try {
            return userDAO.getUserById(id);
        } catch (Exception e) {
            throw new UserServiceException("User with passed id: " + id + " does not exist", e);
        }
    }

    public User getUserByLogin(String login) throws UserServiceException {
        try {
            return userDAO.getUserByLogin(login);
        } catch (Exception e) {
            throw new UserServiceException("User with login: " + login + " does not exist", e);
        }
    }
}
