package com.labus.mycinema.entity;

public class SeatStatus extends Entity {
    private int seansId;
    private int seatId;
    private int status;
    private String user;

    public int getSeansId() {
        return seansId;
    }

    public void setSeansId(int seansId) {
        this.seansId = seansId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public SeatStatus(int id, int seansId, int seatId, int status, String user) {
        super(id);
        this.seansId = seansId;
        this.seatId = seatId;
        this.status = status;
        this.user = user;
    }
}
