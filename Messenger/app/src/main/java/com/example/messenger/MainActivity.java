package com.example.messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth Mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //variable declaration
        Button login,signup;
        EditText username,pass;
        username=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.button);
        signup=findViewById(R.id.button2);
        Mauth=FirebaseAuth.getInstance();
        //calling firebase sdk

//        if(Mauth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(),MainScreen.class));
//            finish();
//
//        }

        //On click function
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u=username.getText().toString();
                String p=pass.getText().toString();
                if(u.isEmpty()){
                    username.setError("Enter the field");
                    pass.requestFocus();
                }
                if(p.isEmpty()){
                    pass.setError("Enter the field");
                    pass.requestFocus();
                }



                Mauth.createUserWithEmailAndPassword(u,p).addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(MainActivity.this,MainScreen.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Failed to Login",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
                finish();

            }
        });



    }
}