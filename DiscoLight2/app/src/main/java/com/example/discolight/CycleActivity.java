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

public class CycleActivity extends AppCompatActivity {
    private ConstraintLayout cyclelayout;
    int number=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle);
        getSupportActionBar().hide();
        cyclelayout=findViewById(R.id.cyclelayout);
        Button startcycle=findViewById(R.id.startcycle);

        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.wind);

        startcycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Runnable run=new Runnable() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void run() {
                        number++;
                        Random r = new Random();
                        int color = Color.argb(196, r.nextInt(222), r.nextInt(255), r.nextInt(180));
                        cyclelayout.setBackgroundColor(color);
                        handler.postDelayed(this,300);
                    }
                };handler.post(run);

            }
        });




    }public void onBackPressed() {
        Intent i = new Intent(CycleActivity.this,
                MainActivity2.class);
        startActivity(i);
        finish();
        onDestroy();
    }
}