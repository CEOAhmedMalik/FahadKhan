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

public class Signup_form extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    EditText txtFullName, txtContactNumber, txtEmail,txtPassword,txtConfirmPassword;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);
        txtFullName=(EditText)findViewById(R.id.FullName);
        txtEmail=(EditText)findViewById(R.id.txt_email);
        txtContactNumber=(EditText)findViewById(R.id.ContactNumber);
        txtPassword=(EditText)findViewById(R.id.txt_password);
        txtConfirmPassword=(EditText)findViewById(R.id.txt_confirm_password);
        register=(Button) findViewById(R.id.Register);
        firebaseAuth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtEmail.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                String confirm_password=txtConfirmPassword.getText().toString().trim();
                String Name=txtFullName.getText().toString();
                String Contact=txtContactNumber.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Signup_form.this, "Please Fill Form Completely",Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_form.this, "Please Fill Form Completely",Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(confirm_password)){
                    Toast.makeText(Signup_form.this, "Please Fill Form Completely",Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(Name)){
                    Toast.makeText(Signup_form.this, "Please Fill Form Completely",Toast.LENGTH_SHORT);
                    return;
                }
                if (TextUtils.isEmpty(Contact)){
                    Toast.makeText(Signup_form.this, "Please Fill Form Completely",Toast.LENGTH_SHORT);
                    return;
                }

                if(password.equals(confirm_password)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                            startActivity(new Intent(getApplicationContext(),Login_form.class));
                                        Toast.makeText(Signup_form.this, "Registered",Toast.LENGTH_SHORT);
                                    } else {
                                        Toast.makeText(Signup_form.this, "Authentication Failed",Toast.LENGTH_SHORT);
                                    }
                                    // ...
                                }
                            });
                }
                }
        });
    }

    public void btn_SF(View view) {
        startActivity(new Intent(getApplicationContext(),Login_form.class));
    }
}