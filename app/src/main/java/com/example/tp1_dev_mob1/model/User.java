package com.example.tp1_dev_mob1.model;

public class User {

    private String UserName ;
    private String password;

    public User(String userName, String password) {
        this.UserName = userName;
        this.password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public  String getPassword() {
        return password;
    }



}
