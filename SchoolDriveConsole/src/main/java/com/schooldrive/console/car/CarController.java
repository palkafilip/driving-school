package com.schooldrive.console.car;

import com.schooldrive.logic.car.CarPresentation;
import com.schooldrive.logic.car.CarService;
import com.schooldrive.logic.car.CarServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAllCar() {
        List<CarPresentation> cars = carService
                .getAllCars()
                .stream()
                .map(car -> new CarPresentation(car))
                .collect(Collectors.toList());

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCarById(@PathVariable Integer carId) throws CarServiceException {
        CarPresentation car = new CarPresentation(carService.getCarById(carId));
        return new ResponseEntity<Object>(car, HttpStatus.OK);
    }

}
