package com.example.database;

import static java.util.Objects.*;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static Object ViewHolder;
    private Object MainData;

    public MainAdapter(MainActivity mainActivity, List<com.example.database.MainData> datalist) {

    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        public void onBindViewHolder(MainAdapter.ViewHolder);
        Objects holder;
        int position = 0) {
        ArrayList dataList;
        MainData=dataList.get(position);
        Object database = RoomDB.getInstance(context);
        BreakIterator data;
        holder.textView.setText(data.getText());
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Class<?> d = dataList.getClass();
                int sID = d.getId();
                String sText = d.getText();
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();
                EditText editText = dialog.findViewById(R.id.textView);
                Button btupdate = dialog.findViewById(R.id.button);
                editText.setText(sText);
                btupdate.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        String uText = editText.toString().trim();
                        RoomDB database=null;
                        database.mainDao().update(sID, uText);
                        dataList.clear();
                        dataList.addAll(database.mainDao().getAll());
                        notifyDataSetChanged();
                        
                    }

                });
                holder.btdelete.setOnClickListner(new View.OnClickListener(){

                    @Override
           public void onClick(View view) {
               MainData d=dataList.get(holder.getAdapterPosition);
               RoomDB database = null;
               database.mainDao().delete(d);
               int position=holder.getAdapterposition();
               dataList.remove(position);
               notifyItemChanged(position);
               notifyItemChanged(position,dataList.size());
           }

           public int getItemCount() {

        return dataList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            View textView = itemView.findViewById(R.id.textView);
            View btEdit = itemView.findViewById(R.id.buttonadd);
            View btreset = itemView.findViewById(R.id.buttonreset);
            
        }
    }