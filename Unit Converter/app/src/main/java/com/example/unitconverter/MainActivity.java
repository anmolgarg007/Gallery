package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    Button b1;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.input);
        sp1=findViewById(R.id.spinner);
        sp1=findViewById(R.id.spinner2);
        b1=findViewById(R.id.button2);

        String[] from={"Kg","Lbs"};
        ArrayAdapter<String> ad1=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad1);
        String[] to={"Kg","Lbs"};
        ArrayAdapter<String> ad2=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad2);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                double tot;
                double input=Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString().equals("Kg") && sp2.getSelectedItem().toString()=="Lbs"){
                    tot=input*2.2;
                    Toast.makeText( getApplicationContext(), Double.toString(tot),Toast.LENGTH_SHORT).show();

                }
                else if(sp1.getSelectedItem().toString().equals("Lbs") && sp2.getSelectedItem().toString()=="Kg"){
                    tot=input*0.4;
                    Toast.makeText( getApplicationContext(), Double.toString(tot),Toast.LENGTH_SHORT).show();

                }
                else if(sp1.getSelectedItem().toString().equals("Kg") && sp2.getSelectedItem().toString()=="Kg"){
                    Toast.makeText( getApplicationContext(),"Invalid".toString(),Toast.LENGTH_SHORT).show();
                }
                else if(sp1.getSelectedItem().toString().equals("Lbs") && sp2.getSelectedItem().toString()=="Lbs"){
                    Toast.makeText( getApplicationContext(),"Invalid".toString(),Toast.LENGTH_SHORT).show();}


            }
        });

    }
}