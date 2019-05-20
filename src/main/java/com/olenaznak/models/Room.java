package com.olenaznak.models;

public class Room extends GeneralModel{
    private int roomNumber;
    private String type;
    private int bedAmount;
    private int freeBedsAmount;
    private double pricePermONT;
    private int floor;

    public Room(int roomNumber, String type, int bedAmount, int freeBedsAmount, double pricePermONT, int floor) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.bedAmount = bedAmount;
        this.freeBedsAmount = freeBedsAmount;
        this.pricePermONT = pricePermONT;
        this.floor = floor;
    }

    public Room() {
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(int bedAmount) {
        this.bedAmount = bedAmount;
    }

    public int getFreeBedsAmount() {
        return freeBedsAmount;
    }

    public void setFreeBedsAmount(int freeBedsAmount) {
        this.freeBedsAmount = freeBedsAmount;
    }

    public double getPricePermONT() {
        return pricePermONT;
    }

    public void setPricePermONT(double pricePermONT) {
        this.pricePermONT = pricePermONT;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
