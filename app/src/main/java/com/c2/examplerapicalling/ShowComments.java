package com.c2.examplerapicalling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.c2.examplerapicalling.Adapters.CommentAdapter;
import com.c2.examplerapicalling.Api.CommentAPI;
import com.c2.examplerapicalling.Model.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowComments extends AppCompatActivity {

    RecyclerView rvComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_comments);

        rvComments= (RecyclerView) findViewById(R.id.rvComments);
        rvComments.setLayoutManager(new LinearLayoutManager(this));
        CommentAPI commentAPI=RetroFit.getClient().create(CommentAPI.class);

        commentAPI.getcommentsbyid(getIntent().getIntExtra("id",0)).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                CommentAdapter commentAdapter=new CommentAdapter(ShowComments.this,response.body());
                rvComments.setAdapter(commentAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });
    }
}
