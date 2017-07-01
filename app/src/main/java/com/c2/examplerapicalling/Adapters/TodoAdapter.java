package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.Todo;
import com.c2.examplerapicalling.R;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.holderTodo>{

    Context context;
    ArrayList<Todo> todos;

    public TodoAdapter(Context context, ArrayList<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public holderTodo onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=li.inflate(R.layout.todo_details,parent,false);
        return new holderTodo(itemView);
    }

    @Override
    public void onBindViewHolder(holderTodo holder, int position) {
        Todo t=todos.get(position);
        holder.tvtitle.setText(t.getTitle());
        holder.cb.setChecked(t.getCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class holderTodo extends RecyclerView.ViewHolder {
        TextView tvtitle;
        CheckBox cb;

        public holderTodo(View itemView) {

            super(itemView);
            tvtitle= (TextView) itemView.findViewById(R.id.tvTitle);
            cb= (CheckBox) itemView.findViewById(R.id.checkBox);

        }
    }
}
