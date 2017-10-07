package com.schooldrive.console.user;

import com.schooldrive.logic.user.UserService;
import com.schooldrive.persistence.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> getUsers(@RequestParam Integer id) {
        System.out.println(id);
        UserPresentation user = new UserPresentation(userService.getUserById(id));
        System.out.println(user);
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
}
