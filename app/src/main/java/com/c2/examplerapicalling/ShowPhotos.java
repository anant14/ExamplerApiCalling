package com.c2.examplerapicalling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c2.examplerapicalling.Adapters.PhotoAdapter;
import com.c2.examplerapicalling.Api.AlbumAPI;
import com.c2.examplerapicalling.Model.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowPhotos extends AppCompatActivity {
/*
    ImageView tvImage;
    TextView tvTitle;*/
    RecyclerView rvPhotos;
    public static final String TAG="ShowPhotos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_photos);

        rvPhotos= (RecyclerView) findViewById(R.id.rvPhoto);

        rvPhotos.setLayoutManager(new LinearLayoutManager(ShowPhotos.this));

        AlbumAPI albumAPI= RetroFit.getClient().create(AlbumAPI.class);

       albumAPI.getAlbumbyid(getIntent().getIntExtra("userid",0)).enqueue(new Callback<ArrayList<Photo>>() {
           @Override
           public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
               Log.d(TAG, "onResponse: ");
                PhotoAdapter photoAdapter=new PhotoAdapter(response.body(),ShowPhotos.this);
                rvPhotos.setAdapter(photoAdapter);
           }

           @Override
           public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {
               Log.d(TAG, "onFailure: "+t);
           }
       });

/*        tvImage= (ImageView) findViewById(R.id.tvImage);
        tvTitle= (TextView) findViewById(R.id.tvTitle);
        Picasso.with(ShowPhotos.this).load(getIntent().getStringExtra("url")).into(tvImage);
        tvTitle.setText(getIntent().getStringExtra("title"));*/
    }
}
