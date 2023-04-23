package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    EditText editText;
    Button btAdd,btReset;
    RecyclerView recyclerView;
    List<MainData> dataList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.textView);
        btAdd=findViewById(R.id.buttonadd);
        btReset=findViewById(R.id.buttonreset);
        recyclerView=findViewById(R.id.recycleview);

        RoomDB.getInstance(this);
        List<MainData> datalist = database.mainDao().getAll();
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new MainAdapter(MainActivity.this,datalist);
        recyclerView.setAdapter(adapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String sText=editText.getText().toString().trim();
                if(!sText.equals("")){
                    MainData data=new MainData();
                    data.setText(sText);
                    database.mainDao().insert(data);
                    editText.setText("");
                    datalist.clear();
                    datalist.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        btReset.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                database.mainDao().reset(datalist);
                datalist.clear();
                datalist.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });


        }
        public void Submit(View view){

        }

    }