package com.schooldrive.console.hoursinterval;

import com.schooldrive.logic.hoursinterval.HoursIntervalPresentation;
import com.schooldrive.logic.hoursinterval.HoursIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 21.12.2017.
 */
@RestController
@RequestMapping("/rest/hour-intervals")
public class HoursIntervalController {

    HoursIntervalService hoursIntervalService;

    @Autowired
    public HoursIntervalController(HoursIntervalService hoursIntervalService) {
        this.hoursIntervalService = hoursIntervalService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllIntervals() {
        List<HoursIntervalPresentation> hoursIntervalPresentations = this.hoursIntervalService
                .getAllHourIntervals()
                .stream()
                .map(hi -> new HoursIntervalPresentation(hi))
                .collect(Collectors.toList());

        return new ResponseEntity<>(hoursIntervalPresentations, HttpStatus.OK);
    }
}
