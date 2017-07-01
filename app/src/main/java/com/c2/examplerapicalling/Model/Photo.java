package com.c2.examplerapicalling.Model;

/**
 * Created by anant bansal on 6/30/2017.
 */

public class Photo {
    String title;
    String url;
    String thumbnailUrl;

    public Photo(String title, String url, String thumbnailUrl) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
