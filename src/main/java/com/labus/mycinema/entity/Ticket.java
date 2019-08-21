package com.labus.mycinema.entity;

public class Ticket extends Entity {
    private int seatId;
    private int seansId;

    public Ticket(int id, int seatId, int seansId) {
        super(id);
        this.seatId = seatId;
        this.seansId = seansId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeansId() {
        return seansId;
    }

    public void setSeansId(int seansId) {
        this.seansId = seansId;
    }
}
