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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText name,email,newpass,confirmpass;
        name=findViewById(R.id.name);
        email=findViewById(R.id.email2);
        newpass=findViewById(R.id.newpass);
        confirmpass=findViewById(R.id.confirmpass);
        auth=FirebaseAuth.getInstance();
        Button submit=findViewById(R.id.Submit);
        final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://messenger-c7529-default-rtdb.firebaseio.com");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = name.getText().toString();
                String e = email.getText().toString();
                String np = newpass.getText().toString();
                String cp = confirmpass.getText().toString();
                if (n.isEmpty()) {
                    name.setError("Enter Your Name");
                    name.requestFocus();
                }

                    if (e.isEmpty()) {
                        email.setError("Enter Your Email");
                        email.requestFocus();
                    }
                    if (np.isEmpty()) {
                        newpass.setError("Enter Your Password");
                        newpass.requestFocus();
                    }
                    if (cp.isEmpty()) {
                        confirmpass.setError("Enter the previous field first");
                        confirmpass.requestFocus();
                    }
                    else if(!np.equals(cp)){
                        Toast.makeText(SignUp.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                    }
                    else{

                        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.hasChild(String.valueOf(confirmpass).substring(2))){
                                    Toast.makeText(SignUp.this,"Name is taken",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Intent i=new Intent(SignUp.this,MainScreen.class);
                                    startActivity(i);
                                    finish();
                                    databaseReference.push().setValue(n);
                                    databaseReference.push().setValue(e);
                                    databaseReference.push().setValue(np);
                                    Toast.makeText(SignUp.this,"Signup Successfully",Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(SignUp.this,"Failed to Signup",Toast.LENGTH_SHORT).show();

                            }
                        });





                    }
            }

        });}

}