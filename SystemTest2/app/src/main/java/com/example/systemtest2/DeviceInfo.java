package com.example.systemtest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.systemtest2.fragments.MyViewPagerAdapter;
import com.example.systemtest2.fragments.ui.cpu.Cpu;
import com.google.android.material.tabs.TabLayout;
public class DeviceInfo extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        getSupportActionBar().hide();
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);


        VPAdapter vpAdapter = null;
        vpAdapter.addfragment(new cpufrag(), "Cpu");
        //  FragmentManager supportFragmentManager = cpufrag.getSupportFragmentManager();
        vpAdapter = new VPAdapter(getSupportFragmentManager());
        vpAdapter.addfragment(new cpufrag(), "Cpu");

//        vpAdapter.addfragment(new cpufrag(),"Cpu");
//        MyViewPagerAdapter myViewPagerAdapter=new MyViewPagerAdapter(this);

        viewPager.setAdapter(vpAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}