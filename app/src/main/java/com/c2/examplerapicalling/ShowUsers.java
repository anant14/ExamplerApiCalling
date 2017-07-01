package com.c2.examplerapicalling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.c2.examplerapicalling.Adapters.UserAdapter;
import com.c2.examplerapicalling.Api.UserAPI;
import com.c2.examplerapicalling.Model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowUsers extends AppCompatActivity {

    RecyclerView rvUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        rvUsers= (RecyclerView) findViewById(R.id.rvUser);
        rvUsers.setLayoutManager(new LinearLayoutManager(ShowUsers.this));

        UserAPI userAPI=RetroFit.getClient().create(UserAPI.class);
        userAPI.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                UserAdapter userAdapter=new UserAdapter(ShowUsers.this,response.body());
                rvUsers.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }
}
