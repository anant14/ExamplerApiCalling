package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.Post;
import com.c2.examplerapicalling.R;
import com.c2.examplerapicalling.ShowComments;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class PostApater extends RecyclerView.Adapter<PostApater.holderPost>{

    Context context;
    ArrayList<Post> posts;
    public static final String TAG="PostAdapter";
    public PostApater(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public holderPost onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=li.inflate(R.layout.post_details,parent,false);
        return new holderPost(itemView);
    }

    @Override
    public void onBindViewHolder(holderPost holder, int position) {
        final Post p=posts.get(position);
        Log.d(TAG, "onBindViewHolder: "+p.getId());
        holder.tvUserid.setText(String.valueOf(p.getUserid()));
        holder.tvTilte.setText(p.getTitle());
        holder.tvBody.setText(p.getBody());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ShowComments.class);
                i.putExtra("id",p.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class holderPost extends RecyclerView.ViewHolder{
        TextView tvUserid;
        TextView tvTilte;
        TextView tvBody;
        View rootView;
        public holderPost(View itemView) {
            super(itemView);
            tvTilte= (TextView) itemView.findViewById(R.id.tvTitle);
            tvUserid= (TextView) itemView.findViewById(R.id.tvUserid);
            tvBody= (TextView) itemView.findViewById(R.id.tvBody);
            rootView=itemView;
        }
    }
}
