package com.schooldrive.console.instructor;

import com.schooldrive.logic.instructor.InstructorPresentation;
import com.schooldrive.logic.instructor.InstructorService;
import com.schooldrive.logic.instructorrating.InstructorRatingPresentation;
import com.schooldrive.logic.instructorrating.InstructorRatingService;
import com.schooldrive.logic.user.UserServiceException;
import com.schooldrive.persistence.instructorrating.InstructorRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getInstructors() {

        List<InstructorPresentation> instructors = instructorService
                .getAllInstructors()
                .stream()
                .map(instr -> new InstructorPresentation(instr))
                .collect(Collectors.toList());

        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @RequestMapping(value = "/{instructorId}", method = RequestMethod.GET)
    public ResponseEntity<?> getInstructorById(@PathVariable Integer instructorId) {

        InstructorPresentation instructor = new InstructorPresentation(instructorService.getById(instructorId));

        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @RequestMapping(value = "/{instructorId}/ratings", method = RequestMethod.GET)
    public ResponseEntity<?> getRatingsByInstructorId(@PathVariable Integer instructorId) {

        List<InstructorRatingPresentation> instructorRatingPresentations = instructorRatingService
                .getByInstructorId(instructorId)
                .stream()
                .map(ip -> new InstructorRatingPresentation(ip))
                .collect(Collectors.toList());

        return new ResponseEntity<>(instructorRatingPresentations, HttpStatus.OK);
    }

    //DOBRE!!!
    @RequestMapping(value = "/{instructorId}/ratings", params = "userId", method = RequestMethod.GET)
    public ResponseEntity<?> getInstructorRateFromUser(@PathVariable Integer instructorId, @RequestParam Integer userId) {

        InstructorRating instructorRating =
                instructorRatingService.getByInstructorAndUser(instructorId, userId);
        if(instructorRating == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        InstructorRatingPresentation instructorRatingPresentation = new InstructorRatingPresentation(instructorRating);

        return new ResponseEntity<>(instructorRatingPresentation, HttpStatus.OK);
    }


//    @RequestMapping(value = "/instructor/{instructorId}/rating", method = RequestMethod.GET)
//    public ResponseEntity<?> getInstructorRateFromUser(@PathVariable Integer instructorId, @RequestParam Integer userId) {
//
//        InstructorRating instructorRating =
//                instructorRatingService.getByInstructorAndUser(instructorId, userId);
//        if(instructorRating == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        InstructorRatingPresentation instructorRatingPresentation = new InstructorRatingPresentation(instructorRating);
//
//        return new ResponseEntity<>(instructorRatingPresentation, HttpStatus.OK);
//    }

    @RequestMapping(value = "/{instructorId}/ratings", method = RequestMethod.POST)
    public ResponseEntity<?> addNewRating(@RequestBody InstructorRatingPresentation rating) throws UserServiceException, ParseException {

        instructorRatingService.addInstructorRating(rating);

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
