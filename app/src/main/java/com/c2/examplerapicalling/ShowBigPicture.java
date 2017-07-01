package com.c2.examplerapicalling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowBigPicture extends AppCompatActivity {

    ImageView tvImage;
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big_picture);

        tvImage= (ImageView) findViewById(R.id.tvImage);
        tvTitle= (TextView) findViewById(R.id.tvTitle);

        Picasso.with(this).load(getIntent().getStringExtra("url")).into(tvImage);
        tvTitle.setText(getIntent().getStringExtra("title"));
    }
}
