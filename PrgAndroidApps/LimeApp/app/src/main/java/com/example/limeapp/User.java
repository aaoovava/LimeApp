package com.example.limeapp;

public class User {
    String name, number, password, age, Aboniment_start_date, Aboniment_end_date, Aboniment_status, Group_t_countStart, Group_t_countEnd, image, freeze_days,freeze_date;

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

    public String getAboniment_status() {
        return Aboniment_status;
    }

    public void setAboniment_status(String aboniment_status) {
        Aboniment_status = aboniment_status;
    }

    public String getGroup_t_countStart() {
        return Group_t_countStart;
    }

    public void setGroup_t_countStart(String group_t_countStart) {
        Group_t_countStart = group_t_countStart;
    }

    public String getGroup_t_countEnd() {
        return Group_t_countEnd;
    }

    public void setGroup_t_countEnd(String group_t_countEnd) {
        Group_t_countEnd = group_t_countEnd;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFreeze_days() {
        return freeze_days;
    }

    public void setFreeze_days(String freeze_days) {
        this.freeze_days = freeze_days;
    }

    public String getFreeze_date() {
        return freeze_date;
    }

    public void setFreeze_date(String freeze_date) {
        this.freeze_date = freeze_date;
    }

    public User(String name, String number, String password, String age, String aboniment_start_date, String aboniment_end_date, String aboniment_status, String group_t_countStart, String group_t_countEnd, String image, String freeze_days, String freeze_date) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.age = age;
        Aboniment_start_date = aboniment_start_date;
        Aboniment_end_date = aboniment_end_date;
        Aboniment_status = aboniment_status;
        Group_t_countStart = group_t_countStart;
        Group_t_countEnd = group_t_countEnd;
        this.image = image;
        this.freeze_days = freeze_days;
        this.freeze_date = freeze_date;
    }
}