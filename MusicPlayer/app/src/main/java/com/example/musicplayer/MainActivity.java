package com.example.musicplayer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.window.SplashScreen;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
public class MainActivity extends AppCompatActivity {

    private GoogleSignInClient client;
     EditText inputusername,inputpassword;
     String emailpattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
     String empty=null;
     ProgressDialog progressDialog;
     FirebaseAuth mAuth;
     FirebaseUser muser;
     ImageView google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        inputusername = findViewById(R.id.inputusername);
        inputpassword=findViewById(R.id.inputpassword);
        Button button=findViewById(R.id.button);

        Button google = findViewById(R.id.buttongoogle);
        Button login = findViewById(R.id.buttonlogin);
        Button facebook = findViewById(R.id.buttonfacebook);
        Button spotify = findViewById(R.id.buttonspotify);
        progressDialog =new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        muser=mAuth.getCurrentUser();
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                finish();
//                Intent i=new Intent(MainActivity.this,GoogleSignActivity.class);
//                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                authentication();
            }



        });
    }  private void authentication() {
        String u=inputusername.getText().toString();
        String p=inputpassword.getText().toString();
        if(!inputusername.equals(empty)){
            inputusername.setError(null);
            if(!inputpassword.equals(empty)){
                inputpassword.setError(null);
            }

        }
        if(inputusername.equals(emailpattern)){
            inputusername.setError("Enter correct email");

        }else if(inputpassword.length()<6||inputpassword.equals(empty)){
            inputpassword.setError("Enter correct password");

        }else{
            progressDialog.setMessage("Please Wait...");
            progressDialog.setTitle("LOGIN...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT);

                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,""+task.getException(),Toast.LENGTH_SHORT);


                    }

                }
            });
        }
    }

}