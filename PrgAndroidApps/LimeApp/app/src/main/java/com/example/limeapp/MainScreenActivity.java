package com.example.limeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainScreenActivity extends AppCompatActivity {
    FirebaseDatabase db;
    private String name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));

        TextView start_date = findViewById(R.id.firstDate);
        TextView end_date = findViewById(R.id.lastDate);
        TextView name = findViewById(R.id.Name);
        ImageView profBut = (ImageView) findViewById(R.id.prof_bot);
        ImageView log_out = findViewById(R.id.log_out);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();


        if (user == null){
            toLogin();
        }
        else {
            log_out.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    auth.signOut();
                    toLogin();
                }
            });
            users.child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String usName = snapshot.child("name").getValue().toString();
                    String firstDate = snapshot.child("start_date").getValue().toString();
                    String LastDate = snapshot.child("end_date").getValue().toString();
                    start_date.setText("Дата початку дії: " + firstDate);
                    end_date.setText("Дата закінчення дії: " + LastDate );

                    name.setText(usName);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        profBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfile();
            }
        });


        }

    }
    void toProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    void toLogin(){
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }
}
