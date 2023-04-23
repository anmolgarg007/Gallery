package com.example.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class ScaryActivity extends AppCompatActivity {
    int number=1;
    int[] colors={R.color.DarkGreen,R.color.Blue,R.color.red,R.color.green,
            R.color.yellow,R.color.pink,R.color.Cyan,R.color.DarkOrange,R.color.LightSeaGreen,
            R.color.LightSkyBlue,R.color.DarkCyan,R.color.LightPink,R.color.Black,
            R.color.Coral};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scary);
        ConstraintLayout f1=findViewById(R.id.f1s);
        ConstraintLayout f2=findViewById(R.id.f2s);
        ConstraintLayout f3=findViewById(R.id.f3s);
        ConstraintLayout f4=findViewById(R.id.f4s);
        ConstraintLayout f5=findViewById(R.id.f5s);
        ConstraintLayout f6=findViewById(R.id.f6s);

        Button start=findViewById(R.id.scarystart);
        final Handler handler=new Handler();
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.scary);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        number++;
                        Random r = new Random();
                        f1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        handler.postDelayed(this, 300);
                    }
                };handler.post(run);
            }
        });
    }@Override
    public void onBackPressed() {
        Intent i = new Intent(ScaryActivity.this,
                MainActivity2.class);

        startActivity(i);
        finish();
        onDestroy();
    }
}