package com.schooldrive.console.instructor;

import com.schooldrive.logic.instructor.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 02.12.2017.
 */
@RestController
@RequestMapping("/rest/instructors")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {

        List<InstructorPresentation> instructors = instructorService
                .getAllInstructors()
                .stream()
                .map(instr -> new InstructorPresentation(instr))
                .collect(Collectors.toList());

        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }
}
