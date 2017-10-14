package com.schooldrive.persistence.user;

/**
 * Created by Filip on 02.10.2017.
 */
public interface UserDAO {
    User getUserById(Integer id);
    User getUserByLogin(String login);
}
