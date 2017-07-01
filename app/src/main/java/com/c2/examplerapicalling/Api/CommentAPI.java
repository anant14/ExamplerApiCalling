package com.c2.examplerapicalling.Api;

import com.c2.examplerapicalling.Model.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anant bansal on 6/29/2017.
 */

public interface CommentAPI {

    @GET("/posts/{id}/comments")
    Call<ArrayList<Comment>> getcommentsbyid(@Path("id") int id);
}
