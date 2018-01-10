package com.schooldrive.console.car;

import com.schooldrive.logic.car.CarPresentation;
import com.schooldrive.logic.car.CarService;
import com.schooldrive.logic.car.CarServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Filip on 13.10.2017.
 */
@RestController
@RequestMapping("/rest/cars")
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@RequestParam Integer id) throws CarServiceException {
        CarPresentation car = new CarPresentation(carService.getCarById(id));
        return new ResponseEntity<Object>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCars() {

        List<CarPresentation> cars = carService
                .getAllCars()
                .stream()
                .map(car -> new CarPresentation(car))
                .collect(Collectors.toList());

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

}
