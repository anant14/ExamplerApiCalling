package com.c2.examplerapicalling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAlbum;
    Button btnUser;
    Button btnPost;
    Button btnTodo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlbum= (Button) findViewById(R.id.btnAlbum);
        btnUser= (Button) findViewById(R.id.btnUser);
        btnPost= (Button) findViewById(R.id.btnPost);
        btnTodo= (Button) findViewById(R.id.btnTodo);

        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowAlbum.class);
                startActivity(i);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowUsers.class);
                startActivity(i);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowPost.class);
                startActivity(i);
            }
        });
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowTodo.class);
                startActivity(i);
            }
        });
    }
}
