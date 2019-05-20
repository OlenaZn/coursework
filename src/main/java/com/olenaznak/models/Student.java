package com.olenaznak.models;

import java.util.Date;
import java.util.List;

public class Student extends GeneralModel{
    private String studentCardNumber;
    private String surname;
    private String name;
    private String fathersNme;
    private Date birthday;
    private String institution;
    private String group;
    private String residence;
    private String phone;
    private String hobby;
    private List<Violation> violationList;

    public List<Violation> getViolationList() {
        return violationList;
    }

    public void setViolationList(List<Violation> violationList) {
        this.violationList = violationList;
    }

    public Student(String studentCardNumber, String surname, String name, String fathersNme,
                   Date birthday, String institution, String group, String residence, String phone, String hobby) {
        this.studentCardNumber = studentCardNumber;
        this.surname = surname;
        this.name = name;
        this.fathersNme = fathersNme;
        this.birthday = birthday;
        this.institution = institution;
        this.group = group;
        this.residence = residence;
        this.phone = phone;
        this.hobby = hobby;
    }

    public Student() {
    }

    public String getStudentCardNumber() {
        return studentCardNumber;
    }

    public void setStudentCardNumber(String studentCardNumber) {
        this.studentCardNumber = studentCardNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersNme() {
        return fathersNme;
    }

    public void setFathersNme(String fathersNme) {
        this.fathersNme = fathersNme;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getinstitution() {
        return institution;
    }

    public void setinstitution(String institution) {
        this.institution = institution;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
