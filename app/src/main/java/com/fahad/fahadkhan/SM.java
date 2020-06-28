package com.fahad.fahadkhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m);
    }

    public void btn_fb(View view) {
        startActivity(new Intent(getApplicationContext(),facebook.class));
    }

    public void btn_ig(View view) {
        startActivity(new Intent(getApplicationContext(),instagram.class));
    }

    public void btn_t(View view) {
        startActivity(new Intent(getApplicationContext(),twitter.class));
    }
}