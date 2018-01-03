package com.schooldrive.persistence.car;

import com.schooldrive.persistence.carrating.CarRating;
import com.schooldrive.persistence.drivebooking.DriveBooking;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Filip on 21.09.2017.
 */
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Date year;

    @Column(name = "engine_capacity", nullable = false)
    private Integer engineCapacity;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @OneToMany(mappedBy = "car")
    private Set<CarRating> carRatings = new HashSet<>();

    @OneToMany(mappedBy = "car")
    private Set<DriveBooking> driveBookings = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Set<CarRating> getCarRatings() {
        return carRatings;
    }

    public void setCarRatings(Set<CarRating> carRatings) {
        this.carRatings = carRatings;
    }

    public Set<DriveBooking> getDriveBookings() {
        return driveBookings;
    }

    public void setDriveBookings(Set<DriveBooking> driveBookings) {
        this.driveBookings = driveBookings;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engineCapacity=" + engineCapacity +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (year != null ? !year.equals(car.year) : car.year != null) return false;
        if (engineCapacity != null ? !engineCapacity.equals(car.engineCapacity) : car.engineCapacity != null)
            return false;
        return fuelType != null ? fuelType.equals(car.fuelType) : car.fuelType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (engineCapacity != null ? engineCapacity.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        return result;
    }
}
