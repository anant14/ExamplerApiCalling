package com.c2.examplerapicalling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class ShowTodobyID extends AppCompatActivity {

    TextView tv;
    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_todoby_id);

        tv= (TextView) findViewById(R.id.tvTitle);
        cb= (CheckBox) findViewById(R.id.checkBox);

        tv.setText(getIntent().getStringExtra("title"));
        cb.setChecked(getIntent().getBooleanExtra("completed",false));
    }
}
