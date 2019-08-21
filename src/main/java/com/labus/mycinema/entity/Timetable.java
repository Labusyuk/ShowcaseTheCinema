package com.labus.mycinema.entity;

import java.sql.Timestamp;

public class Timetable extends Entity {
    private Timestamp time;
    private int movieId;
    private int price;
    private short visible;

    public Timetable(int id, Timestamp time, int movieId, int price, short visible) {
        super(id);
        this.time = time;
        this.movieId = movieId;
        this.price = price;
        this.visible = visible;
    }

    public Timetable() {

    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
}
