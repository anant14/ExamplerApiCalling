package com.c2.examplerapicalling.Api;

import com.c2.examplerapicalling.Model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anant bansal on 6/29/2017.
 */

public interface PostAPI {

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/posts")
    Call<ArrayList<Post>> getPostforid(@Query("userId") int userid);
}
