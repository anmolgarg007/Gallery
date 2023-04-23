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

public class DiscoActivity extends AppCompatActivity {
    int number=1;
    int[] colors={R.color.MediumSpringGreen,R.color.Blue,R.color.red,R.color.green,
            R.color.yellow,R.color.pink,R.color.Cyan,R.color.DarkOrange,R.color.LightSeaGreen,
            R.color.LightSkyBlue,R.color.HotPink,R.color.Magenta,R.color.Black};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco);
        ConstraintLayout f1=findViewById(R.id.f1d);
        ConstraintLayout f2=findViewById(R.id.f2d);
        ConstraintLayout f3=findViewById(R.id.f3d);
        ConstraintLayout f4=findViewById(R.id.f4d);
        ConstraintLayout f5=findViewById(R.id.f5d);
        ConstraintLayout f6=findViewById(R.id.f6d);
        Button start=findViewById(R.id.startdisco);
        final Handler handler=new Handler();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.bad_style_time_back);
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
                        //for f3
                        f3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        //for f4
                        f4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                        //for f5
                        f5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));
                       //for f6
                        f6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),colors[r.nextInt(colors.length)]));

                        handler.postDelayed(this,300);
                    }
                };handler.post(run);
            }
        });

    }@Override
    public void onBackPressed() {
        Intent i = new Intent(DiscoActivity.this,
                MainActivity2.class);

        startActivity(i);
        finish();
        onDestroy();
    }
}