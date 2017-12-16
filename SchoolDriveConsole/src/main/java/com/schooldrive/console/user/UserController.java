package com.schooldrive.console.user;

import com.schooldrive.console.exception.RestErrorHandler;
import com.schooldrive.logic.user.RegisterUser;
import com.schooldrive.logic.user.UserPresentation;
import com.schooldrive.logic.user.UserService;
import com.schooldrive.logic.user.UserServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Filip on 06.10.2017.
 */
@RestController
@RequestMapping("/rest/users")
public class UserController {

    UserService userService;

//    private static final Logger LOGGER = Logger.getLogger(UserController.class);
    final Logger logger = LoggerFactory.getLogger(UserController.class);
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
    public ResponseEntity<?> loginUser(@RequestHeader("Authorization") String authorization) throws UserServiceException {

        // getting login and password from header
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
        final String[] loginPassword = credentials.split(":",2);

        UserPresentation loggedUser = new UserPresentation(userService.getUserByLogin(loginPassword[0]));

        return new ResponseEntity<>(loggedUser,HttpStatus.OK);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody RegisterUser userToRegister) throws UserServiceException {
        userService.registerUser(userToRegister);
        return new ResponseEntity<>(userToRegister, HttpStatus.OK);
    }
    @RequestMapping(value = "/logged")
    public ResponseEntity<?> checkIfLogged() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/settings/data-change", method = RequestMethod.POST)
    public ResponseEntity<?> changeData(@RequestBody UserPresentation user) throws UserServiceException {

        logger.info("test loggera");

        UserPresentation updatedUser = new UserPresentation(userService.updateUserPersonalData(user));
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
//    @RequestMapping(value = "/settings/password", method = RequestMethod.POST)
//    public ResponseEntity<?> changePassword(@RequestBody UserPresentation user) {
//
//        UserPresentation updatedUser = new UserPresentation(userService.updateUserPersonalData(user));
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }

}
