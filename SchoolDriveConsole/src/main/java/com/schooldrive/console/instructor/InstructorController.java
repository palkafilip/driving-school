package com.schooldrive.console.instructor;

import com.schooldrive.logic.instructor.InstructorService;
import com.schooldrive.logic.instructorrating.InstructorRatingService;
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

    private InstructorService instructorService;
    private InstructorRatingService instructorRatingService;

    @Autowired
    public InstructorController(InstructorService instructorService, InstructorRatingService instructorRatingService) {
        this.instructorService = instructorService;
        this.instructorRatingService = instructorRatingService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getInstructors() {

        List<InstructorPresentation> instructors = instructorService
                .getAllInstructors()
                .stream()
                .map(instr -> new InstructorPresentation(instr))
                .collect(Collectors.toList());

        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @RequestMapping(value = "/instructor/{instructorId}", method = RequestMethod.GET)
    public ResponseEntity<?> getInstructorById(@PathVariable Integer instructorId) {

        InstructorPresentation instructor = new InstructorPresentation(instructorService.getById(instructorId));

        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @RequestMapping(value = "instructor/{instructorId}/instructor-ratings", method = RequestMethod.GET)
    public ResponseEntity<?> getRatingsByInstructorId(@PathVariable Integer instructorId) {

        List<InstructorRatingPresentation> instructorRatingPresentations = instructorRatingService
                .getByInstructorId(instructorId)
                .stream()
                .map(ip -> new InstructorRatingPresentation(ip))
                .collect(Collectors.toList());

        return new ResponseEntity<>(instructorRatingPresentations, HttpStatus.OK);
    }
}
