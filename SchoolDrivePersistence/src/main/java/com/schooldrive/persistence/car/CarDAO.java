package com.schooldrive.persistence.car;

/**
 * Created by Filip on 02.10.2017.
 */
public interface CarDAO {
    void addCar(Car car);
    Car getCarById(Integer id);
}
