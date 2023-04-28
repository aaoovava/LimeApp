package com.example.limeapp;

public class User {
    String name,number,password,age,start_date,end_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String name, String number, String password, String age, String start_date, String end_date) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.age = age;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
