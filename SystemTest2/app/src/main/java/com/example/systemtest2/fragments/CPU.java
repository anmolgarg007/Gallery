package com.example.systemtest2.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.systemtest2.R;
import com.example.systemtest2.fragments.ui.cpu.Cpu;

public class CPU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p_u);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Cpu.newInstance())
                    .commitNow();
        }
    }
}