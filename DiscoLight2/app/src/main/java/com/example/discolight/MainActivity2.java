package com.example.discolight;

import static com.example.discolight.R.color.*;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity  {
    private static int O=0;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //declration of the buttons
        Button btnstatic;Button btncycle;Button btnbreathing;
        Button btnstorm;Button btnmusic;Button btnrainbow;
        Button btnscary; Button btnwaves; Button btndisco;
        getSupportActionBar().hide();

        //Listener


        //listener of static
        //View screenView = findViewById(R.id.layout2);
        btnstatic=findViewById(R.id.btnstatic);
        btnstatic.setOnClickListener(this::onClick);
        btnstatic.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"NonConstantResourceId", "ResourceAsColor"})
            @Override
            public void onClick(View view) {

               // btnstatic.setBackgroundColor(white);
                        Intent i=new Intent(MainActivity2.this,
                                StaticActivity.class);
                //Intent is used to switch from one activity to another.
                        startActivity(i);
                        //btnstatic.setBackgroundResource(red);
                        //change color of the button
                        //invoke the SecondActivity.
                        finish();
                        //the current activity will get finished

            }
        });
        //listener of cycle
        btncycle=findViewById(R.id.btncycle);

        btncycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                CycleActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });

        //listener of breathing
        btnbreathing=findViewById(R.id.btnbreathing);
        btnbreathing.setOnClickListener(view -> {
                    Intent i=new Intent(MainActivity2.this,
                            BreathingActivity.class);
                    //Intent is used to switch from one activity to another.
                    startActivity(i);
                    //invoke the SecondActivity.
                    finish();
                    //the current activity will get finished.

        });
        //listener of storm
        btnstorm=findViewById(R.id.btnstrom);
        btnstorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                StormActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);
            }
        });


        //listener of music
        btnmusic=findViewById(R.id.btnmusic);
        btnmusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                MusicActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });

        //listener of rainbow
        btnrainbow=findViewById(R.id.btnrainbow);
        btnrainbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                RainbowActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });
        //listener of scary
        btnscary=findViewById(R.id.btnscary);
        btnscary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                ScaryActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });
        //listener of wave

        btnwaves=findViewById(R.id.btnwaves);
        btnwaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                WaveActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });
        //listener of disco
        btndisco=findViewById(R.id.btndisco);
        btndisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i=new Intent(MainActivity2.this,
                                DiscoActivity.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                },O);

            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void onClick(View view) {
        int id=view.getId();
        if (id == R.id.btnstatic) {
            layout.setBackgroundResource(green);
        }
}}