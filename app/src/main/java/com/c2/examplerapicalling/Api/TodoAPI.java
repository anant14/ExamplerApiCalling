package com.c2.examplerapicalling.Api;

import com.c2.examplerapicalling.Model.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by anant bansal on 6/29/2017.
 */

public interface TodoAPI {

    @GET("/todos")
    Call<ArrayList<Todo>> gettodos();

    @GET("/todos/{id}")
    Call<Todo> gettodosbyid(@Path("id") int id);
}
