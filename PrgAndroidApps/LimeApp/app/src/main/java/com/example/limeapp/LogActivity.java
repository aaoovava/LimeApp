package com.example.limeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));

        TextView TxtButReg = (TextView) findViewById(R.id.textREg);
        Button ButtonLog = findViewById(R.id.login_button);
        EditText phoneEdit = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText pswEdit = (EditText)findViewById(R.id.editTextTextPersonName2);
        ButtonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (phoneEdit.getText().toString().equals("") || pswEdit.getText().toString().equals("")){

                    Toast toast = Toast.makeText(LogActivity.this,"Неправельний номер чи пароль",Toast.LENGTH_LONG);
                    toast.show();
                }else toMain();
            }
        });
        TxtButReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toReg();
            }
        });
    }
    void toReg(){
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }
    void toMain(){
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

}