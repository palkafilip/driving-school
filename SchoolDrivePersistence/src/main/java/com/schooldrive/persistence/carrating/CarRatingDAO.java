package com.schooldrive.persistence.carrating;

/**
 * Created by Filip on 02.10.2017.
 */
public interface CarRatingDAO {

    void addCarRating(CarRating carRating);
    CarRating getCarRatingById(Integer id);
}
