package com.schooldrive.console.config;

import com.schooldrive.logic.user.UserService;
import com.schooldrive.persistence.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Filip on 11.10.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user;

        try {
            user = userService.getUserByLogin(s);

        } catch (Exception e) {
            throw new UsernameNotFoundException("username not found:" + s);
        }

        return new UserPrincipal(user);
    }
}
