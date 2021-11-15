package com.example.assignment1;

public class DBhelper {
    String name;
    String id_no;
    String address;
    String town;
    String gender;
    String f_gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getGender(){return gender;}

    public void setGender(String gender){this.gender = gender;}

    public String getF_gender(){return f_gender;}

    public void setF_gender(String Gender){this.f_gender =f_gender;}

    public DBhelper(String name, String id_no, String address, String town, String gender, String Gender) {
        this.name = name;
        this.id_no = id_no;
        this.address = address;
        this.town = town;
        this.gender = gender;
        this.f_gender =f_gender;
    }

}
