package com.schooldrive.console.user;

import com.schooldrive.logic.user.RegisterUser;
import com.schooldrive.logic.user.UserService;
import com.schooldrive.logic.user.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Filip on 06.10.2017.
 */
@RestController
@RequestMapping("/rest/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@RequestParam Integer id) throws UserServiceException {
        UserPresentation user = new UserPresentation(userService.getUserById(id));
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByLogin(@RequestParam String login) throws UserServiceException {
        UserPresentation user = new UserPresentation(userService.getUserByLogin(login));
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody RegisterUser userToRegister) throws UserServiceException {
        System.out.println("TEST");
        userService.registerUser(userToRegister);
        Map<String , String> map = new HashMap<>();
        map.put("operation", "udalo sie kurwaaaaaaaaa");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
