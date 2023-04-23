package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //final keyword for the fixed value

        final Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
        final ImageView img = findViewById(R.id.imageView3);

        // decalrtion of the buttons
        b1 = findViewById(R.id.button); //fade in
        b2 = findViewById(R.id.button2); //zoom out
        b3 = findViewById(R.id.button3); //zoom in
        b4 = findViewById(R.id.button4);// slide left
        b5 = findViewById(R.id.button5); // slide right
        b6 = findViewById(R.id.button6); // slide up
        b7 = findViewById(R.id.button7); // rotate
        b8 = findViewById(R.id.button8); // fade out
        b9 = findViewById(R.id.button9); // move
        //button function for listner
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in));
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out));
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_left));


            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_right));


            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up));


            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate));


            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out));


            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Animation Started",Toast.LENGTH_SHORT).show();

                img.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down));


            }
        });

    }}