package com.example.gallery;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.holder> {



    ArrayList<Uri>data=new ArrayList<Uri>();

    public RvAdapter (ArrayList<Uri> data) {this.data=data;}
    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View v=inflater.inflate(R.layout.item_view,parent,false);
        return new holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Picasso.get().
                load(data.get(position)).
                resize(400,400).
                centerCrop()
                .into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class holder extends RecyclerView.ViewHolder {
        ImageView iv;
        public holder(View itemView){
            super(itemView);
            iv= itemView.findViewById(R.id.iv);
        }
    }
}
