package com.labus.mycinema.entity;

public class Seat extends Entity {
    private short seatId;
    private short seansId;

    public Seat(int id, short seatId, short seansId) {
        super(id);
        this.seatId = seatId;
        this.seansId = seansId;
    }

    public short getSeansId() {
        return seansId;
    }

    public void setSeansId(short seansId) {
        this.seansId = seansId;
    }

    public short getSeatId() {
        return seatId;
    }

    public void setSeatId(short seatId) {
        this.seatId = seatId;
    }
}
