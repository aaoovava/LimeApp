package com.example.limeapp;

public class User {
    String name,number,password,age,Aboniment_start_date,Aboniment_end_date,Personal_t_name,Personal_t_start_date,Personal_t_end_date,image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
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

    public String getAboniment_start_date() {
        return Aboniment_start_date;
    }

    public void setAboniment_start_date(String aboniment_start_date) {
        Aboniment_start_date = aboniment_start_date;
    }

    public String getAboniment_end_date() {
        return Aboniment_end_date;
    }

    public void setAboniment_end_date(String aboniment_end_date) {
        Aboniment_end_date = aboniment_end_date;
    }

    public String getPersonal_t_name() {
        return Personal_t_name;
    }

    public void setPersonal_t_name(String personal_t_name) {
        Personal_t_name = personal_t_name;
    }

    public String getPersonal_t_start_date() {
        return Personal_t_start_date;
    }

    public void setPersonal_t_start_date(String personal_t_start_date) {
        Personal_t_start_date = personal_t_start_date;
    }

    public String getPersonal_t_end_date() {
        return Personal_t_end_date;
    }

    public void setPersonal_t_end_date(String personal_t_end_date) {
        Personal_t_end_date = personal_t_end_date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(String name, String number, String password, String age, String aboniment_start_date, String aboniment_end_date, String personal_t_name, String personal_t_start_date, String personal_t_end_date, String image) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.age = age;
        Aboniment_start_date = aboniment_start_date;
        Aboniment_end_date = aboniment_end_date;
        Personal_t_name = personal_t_name;
        Personal_t_start_date = personal_t_start_date;
        Personal_t_end_date = personal_t_end_date;
        this.image = image;
    }
}