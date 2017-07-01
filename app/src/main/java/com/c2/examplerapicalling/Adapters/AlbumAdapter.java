package com.c2.examplerapicalling.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.c2.examplerapicalling.Model.Album;
import com.c2.examplerapicalling.R;
import com.c2.examplerapicalling.ShowPhotos;

import java.util.ArrayList;

/**
 * Created by anant bansal on 6/29/2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.holderAlbum> {

    ArrayList<Album> album;
    Context context;
    public static final String TAG="AlbumAdapter";
    public AlbumAdapter(ArrayList<Album> album, Context context) {
        this.album = album;
        this.context = context;
    }

    @Override
    public holderAlbum onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView=li.inflate(R.layout.album_details,parent,false);
        return new holderAlbum(itemView);
    }

    @Override
    public void onBindViewHolder(holderAlbum holder, int position) {
        final Album a=album.get(position);
        holder.userid.setText(String.valueOf(a.getUserid()));
        holder.title.setText(a.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, ShowPhotos.class);
                i.putExtra("userid",a.getUserid());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return album.size();
    }

    public class holderAlbum extends RecyclerView.ViewHolder{
        TextView userid;
        TextView title;
        View rootView;
        public holderAlbum(View itemView) {
            super(itemView);
            userid= (TextView) itemView.findViewById(R.id.tvUserid);
            title= (TextView) itemView.findViewById(R.id.tvTitle);
            rootView=itemView;
        }
    }
}
