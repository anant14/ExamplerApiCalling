package com.c2.examplerapicalling.Api;

import com.c2.examplerapicalling.Model.Album;
import com.c2.examplerapicalling.Model.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anant bansal on 6/29/2017.
 */

public interface AlbumAPI {

    @GET("/albums")
    Call<ArrayList<Album>> getAlbum();

    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getAlbumbyid(@Path("id") int id);
}
