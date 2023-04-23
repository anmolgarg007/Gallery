package com.example.beatbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity   {
    private float x,y,dx,dy;
    private Button c1,c2,c3;
    private LinearLayout l=null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button tags
        Button start, create, menu, floating;
        start = findViewById(R.id.btnstart);
        create = findViewById(R.id.btncreate);
        menu = findViewById(R.id.btnmenu);
        l = findViewById(R.id.linear);

        //Beat Buttons

        Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        //media player
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.s1);
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.s2);
        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this, R.raw.s3);
        final MediaPlayer mediaPlayer4 = MediaPlayer.create(this, R.raw.s4);
        final MediaPlayer mediaPlayer5 = MediaPlayer.create(this, R.raw.s5);
        final MediaPlayer mediaPlayer6 = MediaPlayer.create(this, R.raw.s6);
        final MediaPlayer mediaPlayer7 = MediaPlayer.create(this, R.raw.s7);
        final MediaPlayer mediaPlayer8 = MediaPlayer.create(this, R.raw.s8);
        final MediaPlayer mediaPlayer9 = MediaPlayer.create(this, R.raw.s9);
//button for automation
        c1 = findViewById(R.id.btnc1);
        c2 = findViewById(R.id.btnc2);
        c3 = findViewById(R.id.btnc3);
        c1.setVisibility(View.INVISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
        //on click method of buttons


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2.start();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer3.start();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer4.start();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer5.start();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer6.start();

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer7.start();

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer8.start();

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer9.start();
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1.setVisibility(View.VISIBLE);
                c2.setVisibility(View.VISIBLE);
                c3.setVisibility(View.VISIBLE);

            }


        });
        c1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x,y;
                x=event.getX();
                y=event.getY();

                return false;
            }
        });





    }}
