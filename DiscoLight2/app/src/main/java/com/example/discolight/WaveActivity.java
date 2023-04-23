package com.example.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

public class WaveActivity extends AppCompatActivity {
    int number=1;
    int[] colors={R.color.DarkOrange,R.color.Blue,R.color.red,R.color.green,
            R.color.yellow,R.color.pink,R.color.Cyan,R.color.DarkOrange,R.color.LightSeaGreen,
            R.color.LightSkyBlue,R.color.MediumSpringGreen,R.color.DarkGreen};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_activity);
        FrameLayout f1=findViewById(R.id.f1);
        FrameLayout f2=findViewById(R.id.f2);
        Button start=findViewById(R.id.startwave);

        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.wave);

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
                        f1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        //for f2
                        f2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        handler.postDelayed(this,200);

                    }
                };handler.post(run);
            }
        });
        }@Override
    public void onBackPressed() {
        Intent i = new Intent(WaveActivity.this,
                MainActivity2.class);

        startActivity(i);
        finish();
        onDestroy();
    }
    }