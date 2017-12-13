package com.schooldrive.logic.user;

import com.schooldrive.logic.utils.UserConverter;
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

    public void registerUser(RegisterUser userToRegister) throws UserServiceException {
        User user = UserConverter.convertRegisterUserToDBUser(userToRegister);
        try {
            userDAO.registerUser(user);
        } catch (Exception e) {
            throw new UserServiceException("Cannot register user");
        }

    }

    public User updateUserPersonalData(UserPresentation userToUpdate) throws UserServiceException {
        User userFromDB = getUserById(userToUpdate.getId());

        userFromDB.setFirstname(userToUpdate.getFirstname());
        userFromDB.setLastname(userToUpdate.getLastname());
        userFromDB.setPhone(userToUpdate.getPhone());
        userFromDB.setEmail(userToUpdate.getEmail());
        userFromDB.setPassword(userToUpdate.getPassword());

        return userDAO.updateUser(userFromDB);
    }

    public User updateUserPassword(UserPresentation userToUpdate) throws UserServiceException {
        User userFromDB = getUserById(userToUpdate.getId());

        userFromDB.setPassword(userToUpdate.getPassword());

        return userDAO.updateUser(userFromDB);
    }
}
