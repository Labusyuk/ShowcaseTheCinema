package com.labus.mycinema.entity;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class Timetable extends Entity {
    private Timestamp time;
    private int movieId;
    private String movieName;
    private int price;
    private short visible;
    private int ageLimit;
    private String dimension;

    public Timetable(int id, Timestamp time, int movieId, String movieName, int price, short visible, int ageLimit, String dimension) {
        super(id);
        this.time = time;
        this.movieId = movieId;
        this.movieName = movieName;
        this.price = price;
        this.visible = visible;
        this.ageLimit = ageLimit;
        this.dimension = dimension;
    }

    public Timetable() {

    }

    /*public String getTime() {
        return time.toLocalDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }*/
    public Timestamp getTime(){
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
