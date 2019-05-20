package com.olenaznak.models;

import java.util.Date;
import java.util.List;

public class Violation extends GeneralModel {
    private int number;
    private Date date;
    private String type;
    private List<Student> studentList;

    public Violation(int number, Date date, String type) {
        this.number = number;
        this.date = date;
        this.type = type;
    }

    public Violation() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
