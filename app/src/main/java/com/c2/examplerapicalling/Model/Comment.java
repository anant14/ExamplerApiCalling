package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class Comment {

    int postid;
    int id;
    String name;
    String email;
    String body;

    public Comment(int postid, int id, String name, String email, String body) {
        this.postid = postid;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostid() {
        return postid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
