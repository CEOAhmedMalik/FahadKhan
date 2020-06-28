package com.fahad.fahadkhan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_form extends AppCompatActivity {
    EditText txtEmail,txtPassword;
    Button login;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        txtEmail=(EditText)findViewById(R.id.txt_Email);
        txtPassword=(EditText)findViewById(R.id.txt_Password);
        login=(Button) findViewById(R.id.login);
        firebaseAuth= FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login_form.this, "Enter Email",Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Login_form.this, "Enter Password",Toast.LENGTH_SHORT);
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(getApplicationContext(),dashboard.class));
                                } else {

                                    Toast.makeText(Login_form.this, "Login Failed ",Toast.LENGTH_SHORT);

                                }

                                // ...
                            }
                        });


            }
        });
    }

    public void btn_su(View view) {
        startActivity(new Intent(getApplicationContext(),Signup_form.class));
    }
}