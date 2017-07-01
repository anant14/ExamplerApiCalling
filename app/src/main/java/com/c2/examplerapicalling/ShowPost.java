package com.c2.examplerapicalling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c2.examplerapicalling.Adapters.PostApater;
import com.c2.examplerapicalling.Api.PostAPI;
import com.c2.examplerapicalling.Model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPost extends AppCompatActivity {

    RecyclerView rvPost;
    public static final String TAG="ShowPost";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        rvPost= (RecyclerView) findViewById(R.id.rvPost);
        rvPost.setLayoutManager(new LinearLayoutManager(this));

        PostAPI postAPI=RetroFit.getClient().create(PostAPI.class);

        postAPI.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                Log.d(TAG, "onResponse: "+response.body().size());
                PostApater postApater=new PostApater(ShowPost.this,response.body());
                rvPost.setAdapter(postApater);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });

        postAPI.getPostforid(getIntent().getIntExtra("id",0)).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                PostApater postApater=new PostApater(ShowPost.this,response.body());
                rvPost.setAdapter(postApater);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}
