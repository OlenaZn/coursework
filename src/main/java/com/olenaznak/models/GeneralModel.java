package com.olenaznak.models;

public abstract class GeneralModel {
    private int id;

    public GeneralModel(int id) {
        this.id = id;
    }

    public GeneralModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
