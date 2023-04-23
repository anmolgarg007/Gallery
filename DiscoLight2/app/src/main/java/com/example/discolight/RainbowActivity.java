package com.example.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

public class RainbowActivity extends AppCompatActivity {

    FrameLayout f1,f2,f3,f4,f5,f6,f7;
    int number=1;
    //array of colors
    int[] colors={R.color.LightSeaGreen,R.color.Blue,R.color.red,R.color.green,
            R.color.yellow,R.color.pink,R.color.Cyan,R.color.DarkOrange,R.color.LightSeaGreen,
            R.color.LightSkyBlue,R.color.MediumSpringGreen};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainbow);
        Button start=findViewById(R.id.startrainbow);
        f1=findViewById(R.id.f1);
        f2=findViewById(R.id.f2);
        f3=findViewById(R.id.f3);
        f4=findViewById(R.id.f4);
        f5=findViewById(R.id.f5);
        f6=findViewById(R.id.f6);
        f7=findViewById(R.id.f7);
        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.hail);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Runnable run=new Runnable() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void run() {
                        number++;
                        Random r = new Random();
                        //for f1
                        //random color generator using argb effect
                        //int color1 = Color.rgb(r.nextInt(60), r.nextInt(70), r.nextInt(80));

                        //to pass array of colors
                        f1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));

                        //for f2
                        f2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));


                        //for f3
                        f3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));


                        //for f4
                        f4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));


                        //for f5
                        f5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));


                        //for f6
                        f6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));


                        //for f7
                        f7.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));



                        handler.postDelayed(this,200);
                    }
                };handler.post(run);



            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(RainbowActivity.this,
                MainActivity2.class);

        startActivity(i);
        finish();
        onDestroy();
    }}