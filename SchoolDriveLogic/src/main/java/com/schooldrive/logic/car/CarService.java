package com.schooldrive.logic.car;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.car.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Filip on 04.10.2017.
 */
@Service
public class CarService {

    private CarDAO carDAO;

    @Autowired
    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public Car getCarById(Integer id) throws CarServiceException {
        Car car;
        try {
            car = carDAO.getCarById(id);
        } catch (Exception e) {
            throw new CarServiceException("Car with id: " + id + " does not exist");
        }

        return car;
    }
}
