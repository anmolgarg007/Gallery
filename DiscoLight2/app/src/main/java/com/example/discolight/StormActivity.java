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
import android.widget.LinearLayout;

import java.util.Random;

public class StormActivity extends AppCompatActivity {
    private ConstraintLayout storm_layout;
    int number=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storm);
        getSupportActionBar().hide();

        storm_layout=findViewById(R.id.storm_layout);
        Button start = findViewById(R.id.startstorm);
        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.storm);
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
                        int color = Color.argb(200, r.nextInt(240), r.nextInt(256), r.nextInt(256));
                        storm_layout.setBackgroundColor(color);
                        handler.postDelayed(this,20);
                    }
                };handler.post(run);
            }
        });
    }public void onBackPressed() {
        Intent i = new Intent(StormActivity.this,
                MainActivity2.class);
        startActivity(i);
        finish();
        onDestroy();
    }
}