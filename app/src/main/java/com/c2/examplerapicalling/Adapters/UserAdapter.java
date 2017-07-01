package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.User;
import com.c2.examplerapicalling.R;
import com.c2.examplerapicalling.ShowPost;
import com.c2.examplerapicalling.ShowTodo;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.holderUser>{

    Context context;
    ArrayList<User>users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public holderUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemview=li.inflate(R.layout.user_details,parent,false);
        return new holderUser(itemview);
    }

    @Override
    public void onBindViewHolder(holderUser holder, int position) {
        final User u=users.get(position);
        holder.tvusername.setText(u.getUsername());
        holder.tvname.setText(u.getName());
        holder.tvemail.setText(u.getEmail());
        holder.tvStreet.setText(u.getAddress().getStreet());
        holder.tvcity.setText(u.getAddress().getCity());
        holder.btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ShowPost.class);
                i.putExtra("id",u.getId());
                context.startActivity(i);
            }
        });
        holder.btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ShowTodo.class);
                i.putExtra("id",u.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class holderUser extends RecyclerView.ViewHolder {
        TextView tvusername;
        TextView tvname;
        TextView tvemail;
        TextView tvStreet;
        TextView tvcity;
        Button btnPost;
        Button btnTodo;
        public holderUser(View itemView) {
            super(itemView);
            tvusername= (TextView) itemView.findViewById(R.id.tvusername);
            tvname= (TextView) itemView.findViewById(R.id.tvname);
            tvemail= (TextView) itemView.findViewById(R.id.tvemail);
            tvStreet= (TextView) itemView.findViewById(R.id.tvstreet);
            tvcity= (TextView) itemView.findViewById(R.id.tvcity);
            btnPost= (Button) itemView.findViewById(R.id.btnPost);
            btnTodo= (Button) itemView.findViewById(R.id.btnTodo);
        }
    }
}
