package com.example.limeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        TextView TxtButReg = (TextView) findViewById(R.id.textREg);

        TxtButReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I();
            }
        });
    }
    void I(){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

}