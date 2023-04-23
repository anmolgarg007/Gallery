package com.example.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class BreathingActivity extends AppCompatActivity {
    public ConstraintLayout breathing_layout;
    int number=1;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_breathing);
        breathing_layout = findViewById(R.id.breathing_layout);
        Button btnin = findViewById(R.id.buttonin);

        final Handler handler = new Handler();
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.wind);

        Button btnout = findViewById(R.id.buttonout);


        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

                Runnable run = new Runnable() {
                    @Override
                    public void run() {

                        number++;
                        Random r = new Random();
                        int color = Color.argb(200, r.nextInt(240), r.nextInt(256), r.nextInt(256));
                        breathing_layout.setBackgroundColor(color);
                        handler.postDelayed(this, 300);
                    }
                };
                handler.post(run);

            }
        });
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        number++;
                        Random r = new Random();
                        int color = Color.argb(196, r.nextInt(155), r.nextInt(205), r.nextInt(200));
                        breathing_layout.setBackgroundColor(color);
                        handler.postDelayed(this, 300);
                    }
                };handler.post(run);}
        });


    }
    public void onBackPressed() {
        Intent i = new Intent(BreathingActivity.this,
                MainActivity2.class);
        startActivity(i);
        finish();
        onDestroy();
    }
}
