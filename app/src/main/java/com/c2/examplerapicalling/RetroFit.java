package com.c2.examplerapicalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class RetroFit {

   public static Retrofit getClient()
   {
       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl("https://jsonplaceholder.typicode.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       return retrofit;
   }
}
