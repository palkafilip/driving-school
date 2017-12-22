package com.schooldrive.logic.car;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.car.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

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
        } catch (NoResultException e) {
            throw new CarServiceException("Car with id: " + id + " does not exist");
        } catch (Exception e) {
            throw new CarServiceException(e.getMessage(), e);
        }

        return car;
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }
}
