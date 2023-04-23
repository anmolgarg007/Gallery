package com.example.foodorderdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity2 extends AppCompatActivity {

    private CheckBox cbpizza;
    private CheckBox cbkhana;
    private CheckBox cbfamily;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cbpizza = (CheckBox) findViewById(R.id.cbpizza);
        cbkhana = (CheckBox) findViewById(R.id.cbkahana);
        cbfamily = (CheckBox) findViewById(R.id.cbfamily);
            Button btn = (Button) findViewById(R.id.button2);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (cbpizza.isChecked()) {
                        Intent i = new Intent(MainActivity2.this,
                                pizza_king_cafe.class);
                        cbpizza.setTextColor(Color.WHITE);
                        cbpizza.setBackgroundColor(Color.BLACK);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    } else if (cbkhana.isChecked()) {
                        Intent i = new Intent(MainActivity2.this,
                                khana_khazana.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                    if (cbfamily.isChecked()) {
                        Intent i = new Intent(MainActivity2.this,
                                family_point.class);
                        //Intent is used to switch from one activity to another.

                        startActivity(i);
                        //invoke the SecondActivity.

                        finish();
                        //the current activity will get finished.
                    }
                }
            });

        }
}