package com.example.discolight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

public class MusicActivity extends AppCompatActivity {
    int number=1;
    int[] colors={R.color.DarkOrange,R.color.Blue,R.color.red,R.color.green,
            R.color.yellow,R.color.pink,R.color.Cyan,R.color.DarkOrange,R.color.LightSeaGreen,
            R.color.LightSkyBlue,R.color.MediumSpringGreen,R.color.DarkGreen,R.color.black,
            R.color.Gray,R.color.Olive,R.color.OrangeRed};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        FrameLayout f1=findViewById(R.id.f1m);
        FrameLayout f2=findViewById(R.id.f2m);
        FrameLayout f3=findViewById(R.id.f3m);
        FrameLayout f4=findViewById(R.id.f4m);
        ConstraintLayout f5=findViewById(R.id.f5m);
        FrameLayout f6=findViewById(R.id.f6m);
        FrameLayout f7=findViewById(R.id.f7m);
        FrameLayout f8=findViewById(R.id.f8m);
        FrameLayout f9=findViewById(R.id.f9m);
        FrameLayout f10=findViewById(R.id.f10m);
        Button start=findViewById(R.id.musicstart);
        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.hymn_music);
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
                        f2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f7.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f8.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f9.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        f10.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));

                        handler.postDelayed(this,200);

                    }
                };handler.post(run);
            }
        });
    }@Override
    public void onBackPressed() {
        Intent i = new Intent(MusicActivity.this,
                MainActivity2.class);

        startActivity(i);
        finish();
        onDestroy();
    }
}