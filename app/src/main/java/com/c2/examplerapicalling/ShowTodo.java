package com.c2.examplerapicalling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.c2.examplerapicalling.Adapters.TodoAdapter;
import com.c2.examplerapicalling.Api.TodoAPI;
import com.c2.examplerapicalling.Model.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowTodo extends AppCompatActivity {

    RecyclerView rvTodo;
    public static final String TAG="showtodo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_todo);

        rvTodo= (RecyclerView) findViewById(R.id.rvTodo);
        rvTodo.setLayoutManager(new LinearLayoutManager(this));

        TodoAPI todoAPI= RetroFit.getClient().create(TodoAPI.class);

        if(getIntent().getIntExtra("id",0)==0) {
            todoAPI.gettodos().enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    TodoAdapter todoAdapter = new TodoAdapter(ShowTodo.this, response.body());
                    rvTodo.setAdapter(todoAdapter);
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);
                }
            });
        }
        else {
            todoAPI.gettodosbyid(getIntent().getIntExtra("id", 0)).enqueue(new Callback<Todo>() {
                @Override
                public void onResponse(Call<Todo> call, Response<Todo> response) {
                    Intent i = new Intent(ShowTodo.this, ShowTodobyID.class);
                    i.putExtra("title", response.body().getTitle());
                    i.putExtra("completed", response.body().getCompleted());
                    startActivity(i);
                }

                @Override
                public void onFailure(Call<Todo> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t);

                }
            });
        }
    }
}
