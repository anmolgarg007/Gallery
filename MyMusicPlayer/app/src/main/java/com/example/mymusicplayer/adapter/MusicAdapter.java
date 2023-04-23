package com.example.mymusicplayer.adapter;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymusicplayer.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {
   List <Music> list;

    public MusicAdapter(List<Music>list){
        this.list=list;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music,parent));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {

        Music music=list.get(position);
        holder.title.setText(music.title);
        String dur=music.duration+"Minutes";
        holder.duration.setText(dur);
        Glide.with(holder.itemView.getContext());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MusicHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView title,duration;

        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            icon=itemView.findViewById(R.id.item_img);
        }
    }
}
