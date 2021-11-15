package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    EditText user_name, user_password;
    Button m_login;
    TextView m_signup;
    FirebaseAuth m_Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.login_password);
        m_login = findViewById(R.id.btn_login);
        m_signup = findViewById(R.id.textView2);

        m_Auth = FirebaseAuth.getInstance();

        m_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });
        m_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_user();
            }
        });




    }

    private void login_user() {
        String username = user_name.getText().toString();
        String password = user_password.getText().toString();


        if (!username.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            if (!password.isEmpty()){
           m_Auth.signInWithEmailAndPassword(username, password)
                   .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           Toast.makeText(SignIn.this, "LogIn successful!", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(SignIn.this, Home.class));
                           finish();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {
                   Toast.makeText(SignIn.this, "Sign In Failed! Please try again later.", Toast.LENGTH_SHORT).show();
               }
           });

            }else{
                user_password.setError("Please Fill all the details");
            }
        }else if(username.isEmpty()){
            user_name.setError("Please Fill all the Fields");

        } else{
            user_name.setError("Email Incorrect");
        }
    }

}