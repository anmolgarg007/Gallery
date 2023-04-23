package com.example.themechange;
import static com.example.themechange.R.color.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //get id of all the button
        Button btn_red = findViewById(R.id.btn_red);
        Button btn_blue = findViewById(R.id.btn_blue);
        Button btn_green = findViewById(R.id.btn_green);
        Button btn_yellow = findViewById(R.id.btn_yellow);
        layout=findViewById(R.id.layout);
        //click listener buttons
        btn_red.setOnClickListener(this::onClick);
        btn_blue.setOnClickListener(this::onClick);
        btn_green.setOnClickListener(this::onClick);
        btn_yellow.setOnClickListener(this::onClick);



        }
        @SuppressLint("NonConstantResourceId")
        public void onClick(@NonNull View v){

            int id=v.getId();
            switch (id){
                case R.id.btn_red: layout.setBackgroundResource(red);
                    break;
                case R.id.btn_blue:layout.setBackgroundResource(blue);
                    break;
                case R.id.btn_green:layout.setBackgroundResource(green);
                    break;
                case R.id.btn_yellow:layout.setBackgroundResource(yellow);
                    break;
        }}
}