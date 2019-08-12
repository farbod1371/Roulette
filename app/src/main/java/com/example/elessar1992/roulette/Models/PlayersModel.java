package com.example.elessar1992.roulette.Models;

/**
 * Created by elessar1992 on 8/8/19.
 */

public class PlayersModel
{
    String name;
    String email;
    String username;
    String uid;

    public PlayersModel(){}

    public PlayersModel(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUser() {
        return username;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }
}
