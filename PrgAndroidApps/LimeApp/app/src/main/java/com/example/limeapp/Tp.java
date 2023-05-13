package com.example.limeapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class Tp extends AppCompatActivity {

    public void toFreeze(){
        Intent intent = new Intent(this, Freeze.class);
        startActivity(intent);
    }
    public  void toTable(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

}
