package com.example.limeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.sql.SQLException;

public class RegActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));
        TextView TxtButLog = (TextView) findViewById(R.id.textButLog);
        Button RegButton = findViewById(R.id.button_reg);
        TextView Age = (TextView) findViewById(R.id.EditTextAge);
        TextView Phone = (TextView) findViewById(R.id.EditTextPhone);
        TextView Pwd = (TextView) findViewById(R.id.EditTextPass);
        TextView RPwd = (TextView) findViewById(R.id.EditTextPassRep);
        DbHandler dbHandler = new DbHandler();
        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Age.getText().toString().trim().equals("") ||Phone.getText().toString().trim().equals("")||Pwd.getText().toString().trim().equals("")||RPwd.getText().toString().trim().equals("")){
                    Toast toast = Toast.makeText(RegActivity.this,"Заповніть усі поля",Toast.LENGTH_LONG);
                    toast.show();
                } else if (!RPwd.getText().toString().equals(Pwd.getText().toString())) {
                    Toast toast = Toast.makeText(RegActivity.this,"Пролі не співпадають",Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    try {
                        dbHandler.SingUpMember(Phone.getText().toString(),Age.getText().toString(),Pwd.getText().toString());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
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
