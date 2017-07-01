package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class Album {

    int userId;
    int id;
    String title;

    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserid() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
