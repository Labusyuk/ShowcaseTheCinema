package com.labus.mycinema.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Movies extends Entity {
    private String name;
    private String description;
    private int price;
    private Time duration;
    private String genre;
    private int agelimit;
    private String dimension;
    private String production;
    private Date graduationYear;
    private String producer;
    private String scenario;
    private String staring;

    public Movies(int id, String name, String description, int price, Time duration, String genre, int agelimit, String dimension, String production, Date graduationYear, String producer, String scenario, String staring) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.genre = genre;
        this.agelimit = agelimit;
        this.dimension = dimension;
        this.production = production;
        this.graduationYear = graduationYear;
        this.producer = producer;
        this.scenario = scenario;
        this.staring = staring;
    }

    public Movies() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAgelimit() {
        return agelimit;
    }

    public void setAgelimit(int agelimit) {
        this.agelimit = agelimit;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Date getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Date graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getStaring() {
        return staring;
    }

    public void setStaring(String staring) {
        this.staring = staring;
    }
}
