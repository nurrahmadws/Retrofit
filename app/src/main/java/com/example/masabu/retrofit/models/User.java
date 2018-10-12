package com.example.masabu.retrofit.models;

public class User {
    private int id_user;
    private String username, level;

    public User(int id_user, String username, String level) {
        this.id_user = id_user;
        this.username = username;
        this.level = level;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getLevel() {
        return level;
    }
}
