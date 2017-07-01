package com.c2.examplerapicalling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c2.examplerapicalling.Adapters.AlbumAdapter;
import com.c2.examplerapicalling.Api.AlbumAPI;
import com.c2.examplerapicalling.Model.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAlbum extends AppCompatActivity {

    RecyclerView rvAlbum;
    public static final String TAG="ShowAlbum";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_album);

        AlbumAPI albumAPI= RetroFit.getClient().create(AlbumAPI.class);
        rvAlbum= (RecyclerView) findViewById(R.id.rvAlbum);
        rvAlbum.setLayoutManager(new LinearLayoutManager(ShowAlbum.this));

        albumAPI.getAlbum().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                AlbumAdapter albumAdapter  =new AlbumAdapter(response.body(),ShowAlbum.this);
                rvAlbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });


    }
}
