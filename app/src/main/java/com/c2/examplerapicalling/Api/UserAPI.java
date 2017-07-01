package com.c2.examplerapicalling.Api;

import com.c2.examplerapicalling.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anant bansal on 6/29/2017.
 */

public interface UserAPI {

    @GET("/users")
    Call<ArrayList<User>>getUsers();
}
