package com.schooldrive.persistence.car;

import java.util.List;

/**
 * Created by Filip on 02.10.2017.
 */
public interface CarDAO {
    void addCar(Car car);
    Car getCarById(Integer id);
    List<Car> getAllCars();
}
