package com.example.light;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    String [] permission={"android.permission.BLUETOOTH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button pair, on, off, fade, blink, breath;

        pair = findViewById(R.id.btnpair);
        on = findViewById(R.id.btnon);
        off = findViewById(R.id.btnoff);
        fade = findViewById(R.id.btnon);
        blink = findViewById(R.id.btnblink);
        breath = findViewById(R.id.btnbreath);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            requestPermissions(permission,0);
        }


        pair.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
            }
        });

        on.setOnClickListener(v -> {

            if (bluetoothAdapter.isEnabled()) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Permission Already Granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestbluetoothpermission();
                }
                requestbluetoothpermission();
                bluetoothAdapter.enable();
                Toast.makeText(MainActivity.this, "Turning Bluetooth OFF....", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Turning on Bluetooth", Toast.LENGTH_SHORT).show();
                bluetoothAdapter.disable();
            }

       });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
        breath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    private void requestbluetoothpermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.BLUETOOTH_CONNECT)){
            new AlertDialog.Builder(this).setTitle("Permission needed").setMessage("The permission needed because of this and that").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();

        }else{
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.BLUETOOTH_CONNECT},REQUEST_ENABLE_BT);
        }

    }


}