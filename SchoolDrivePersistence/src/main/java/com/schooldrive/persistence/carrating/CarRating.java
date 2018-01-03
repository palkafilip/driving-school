package com.schooldrive.persistence.carrating;

import com.schooldrive.persistence.car.Car;
import com.schooldrive.persistence.user.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Filip on 21.09.2017.
 */
@Entity
@Table(name = "car_rating")
public class CarRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "date", nullable = false)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CarRating{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", comment='" + comment + '\'' +
                ", rate=" + rate +
                ", date=" + date +
                '}';
    }


}
