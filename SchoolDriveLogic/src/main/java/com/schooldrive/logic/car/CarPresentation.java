package com.schooldrive.logic.car;

import com.schooldrive.logic.utils.DateUtils;
import com.schooldrive.persistence.car.Car;

import java.util.Date;

/**
 * Created by Filip on 13.10.2017.
 */
public class CarPresentation {
    private Integer id;
    private String brand;
    private String model;
    private String year;
    private Integer engineCapacity;
    private String fuelType;

    public CarPresentation(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.year = DateUtils.dateYearOnly().format(car.getYear());
        this.engineCapacity = car.getEngineCapacity();
        this.fuelType = car.getFuelType();
    }

    public CarPresentation() {
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }
}
