package com.fahad.fahadkhan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void btn_fk(View view) {
        startActivity(new Intent(getApplicationContext(),profile.class));
    }

    public void btn_youtube(View view1) {
        startActivity(new Intent(getApplicationContext(),youtube.class));
    }

    public void btn_web(View view2) {
        startActivity(new Intent(getApplicationContext(),Web.class));
    }

    public void btn_social(View view3) {
        startActivity(new Intent(getApplicationContext(),SM.class));
    }
}