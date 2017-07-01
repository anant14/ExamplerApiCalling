package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.Photo;
import com.c2.examplerapicalling.R;
import com.c2.examplerapicalling.ShowBigPicture;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/30/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.holderPhoto>{
    ArrayList<Photo> photos;
    Context context;

    public static final String TAG="PhotoAdapter";

    public PhotoAdapter(ArrayList<Photo> photos, Context context) {
        Log.d(TAG, "PhotoAdapter: "+context);
        this.photos = photos;
        this.context = context;
    }

    @Override
    public holderPhoto onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.photo_detail,parent,false);
        return new holderPhoto(itemView);
    }

    @Override
    public void onBindViewHolder(holderPhoto holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
            final Photo p=photos.get(position);
        holder.tvTitle.setText(p.getTitle());
        Picasso.with(context).load(p.getThumbnailUrl()).into(holder.tvImage);
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ShowBigPicture.class);
                i.putExtra("url",p.getUrl());
                i.putExtra("title",p.getTitle());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class holderPhoto extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView tvImage;
        View rootView;
        public holderPhoto(View itemView) {
            super(itemView);
            tvTitle= (TextView) itemView.findViewById(R.id.tvTitle);
            tvImage= (ImageView) itemView.findViewById(R.id.tvImage);
            rootView=itemView;
        }
    }
}
