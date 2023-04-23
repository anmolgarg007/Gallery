package com.example.discolight;

import static android.content.pm.PackageManager.PERMISSION_DENIED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class StaticActivity extends AppCompatActivity {
    private ConstraintLayout static_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);
        getSupportActionBar().hide();
        static_layout=findViewById(R.id.static_layout);
        //button declaration
        Button static_change=findViewById(R.id.static_change);
        Button mic=findViewById(R.id.btnmic);
        final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.beep);
        //mic button listener
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Toast.makeText(StaticActivity.this,"This is a Beta Version",Toast.LENGTH_SHORT).show();
            }
        });

        //static button listerner
        static_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Random r= new Random();
                int color= Color.argb(255,r.nextInt(256),r.nextInt(256),r.nextInt(256));
                static_layout.setBackgroundColor(color);

            }

        });}


    @Override
    //to go to previous activity on pressing the back button
    public void onBackPressed() {
        Intent i = new Intent(StaticActivity.this,
                MainActivity2.class);

        //Intent is used to switch from one activity to another.

        startActivity(i);
        //invoke the SecondActivity.
        finish();
        onDestroy();
        //the current activity will get finished.
    }


}