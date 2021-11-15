package com.example.assignment1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText m_name, m_password;
    Button m_register;
    TextView m_log;
    FirebaseAuth m_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_name = findViewById(R.id.username);
        m_password = findViewById(R.id.password);
        m_register = findViewById(R.id.btn_register);
        m_log = findViewById(R.id.redirect);

        m_auth = FirebaseAuth.getInstance();

        m_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignIn.class));
            }
        });

        m_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_user();
            }
        });
    }

    private void create_user() {
        String username = m_name.getText().toString();
        String password = m_password.getText().toString();

        if (!username.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(username).matches()){
            if (!password.isEmpty()){
                m_auth.createUserWithEmailAndPassword(username, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(MainActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, SignIn.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                    }
                });

            }else{
                m_password.setError("Please Fill all the details");
            }
        }else if(username.isEmpty()){
            m_name.setError("Please Fill all the Fields");

        } else{
            m_name.setError("Email Incorrect");
        }
    }
}