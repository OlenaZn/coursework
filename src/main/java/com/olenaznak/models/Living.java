package com.olenaznak.models;

import java.util.Date;

public class Living extends GeneralModel {
    private Student student;
    private Room room;
    private Date settlement;
    private Date eviction;

    public Living(Student student, Room room, Date settlement, Date eviction) {
        this.student = student;
        this.room = room;
        this.settlement = settlement;
        this.eviction = eviction;
    }

    public Living() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getSettlement() {
        return settlement;
    }

    public void setSettlement(Date settlement) {
        this.settlement = settlement;
    }

    public Date getEviction() {
        return eviction;
    }

    public void setEviction(Date eviction) {
        this.eviction = eviction;
    }
}
