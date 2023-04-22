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

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DriverManager;
import java.sql.SQLException;

public class RegActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);
        //Init all values
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));
        TextView TxtButLog = (TextView) findViewById(R.id.textButLog);
        Button RegButton = findViewById(R.id.button_reg);
        TextView Name = findViewById(R.id.PIB);
        TextView Age = (TextView) findViewById(R.id.EditTextAge);
        TextView Phone = (TextView) findViewById(R.id.EditTextPhone);
        TextView Pwd = (TextView) findViewById(R.id.EditTextPass);
        TextView RPwd = (TextView) findViewById(R.id.EditTextPassRep);
        //
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("users");


        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Age.getText().toString().trim().equals("") ||Phone.getText().toString().trim().equals("")||Pwd.getText().toString().trim().equals("")||RPwd.getText().toString().trim().equals("")||Name.getText().toString().trim().equals("")){
                    Toast toast = Toast.makeText(RegActivity.this,"Заповніть усі поля",Toast.LENGTH_LONG);
                    toast.show();

                } else if (!RPwd.getText().toString().equals(Pwd.getText().toString())) {
                    Toast toast = Toast.makeText(RegActivity.this,"Пролі не співпадають",Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    auth.createUserWithEmailAndPassword(Phone.getText().toString() + "@gmail.com",Pwd.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            User user = new User(Name.getText().toString(),Phone.getText().toString(),Pwd.getText().toString(),Age.getText().toString());
                            users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast toast = Toast.makeText(RegActivity.this,"Регістрація успішна",Toast.LENGTH_LONG);
                                    toast.show();
                                    I();
                                }
                            });
                        }
                    });
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
