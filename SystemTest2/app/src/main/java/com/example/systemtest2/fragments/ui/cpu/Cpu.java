package com.example.systemtest2.fragments.ui.cpu;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.systemtest2.R;
import com.example.systemtest2.fragments.ui.cpu.Cpu;

public class Cpu extends Fragment {

    public static Cpu newInstance() {
        return new Cpu();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CpuViewModel mViewModel = new ViewModelProvider(this).get(CpuViewModel.class);
        // TODO: Use the ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cpu, container, false);
    }

}