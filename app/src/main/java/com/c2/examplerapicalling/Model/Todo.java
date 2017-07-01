package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class Todo {

    int userid;
    int id;
    String title;
    Boolean completed;

    public Todo(int userid, int id, String title, Boolean completed) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserid() {
        return userid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
