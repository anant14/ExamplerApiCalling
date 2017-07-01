package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.Comment;
import com.c2.examplerapicalling.R;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.holderComment>{

    Context context;
    ArrayList<Comment> comments;

    public CommentAdapter(Context context, ArrayList<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public holderComment onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=li.inflate(R.layout.comment_details,parent,false);

        return new holderComment(itemView);
    }

    @Override
    public void onBindViewHolder(holderComment holder, int position) {
        Comment c=comments.get(position);
        holder.tvBody.setText(c.getBody());
        holder.tvemail.setText(c.getEmail());
        holder.tvname.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class holderComment extends RecyclerView.ViewHolder{
        TextView tvBody;
        TextView tvemail;
        TextView tvname;
        public holderComment(View itemView) {

            super(itemView);
            tvBody= (TextView) itemView.findViewById(R.id.tvBody);
            tvemail= (TextView) itemView.findViewById(R.id.tvemail);
            tvname= (TextView) itemView.findViewById(R.id.tvname);
        }
    }
}
