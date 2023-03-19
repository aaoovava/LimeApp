package com.example.limeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class RegActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        TextView TxtButLog = (TextView) findViewById(R.id.textButLog);
        TxtButLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                I();
            }
        });
    }
    void I(){
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }
}
