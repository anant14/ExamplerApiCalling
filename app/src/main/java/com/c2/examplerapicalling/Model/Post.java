package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class Post {
     int userId;
    int id;
    String title;
    String body;

    public Post(int userId,int id, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.id=id;
        this.body = body;
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

    public String getBody() {
        return body;
    }
}
