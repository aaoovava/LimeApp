package com.example.limeapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class GfreezeDrop extends AppCompatActivity {

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gfreeze_drop);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();

        ImageView backBut = findViewById(R.id.baсk);
        TextView date = findViewById(R.id.textView9);
        TextView days = findViewById(R.id.textView11);

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
        users.child(userId).addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Date = (snapshot.child("gfreeze_date").getValue().toString());
                date.setText(Date);
                long daysDiff = dataDifInDaysLocal(Date);
                String a = "Залишилося: ";
                if(daysDiff == 1){
                    a = "Залишився: ";
                }
                days.setText( a + daysDiff + " дн");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void toMain(){
        Intent intent = new Intent(this,MainScreenActivity.class);
        startActivity(intent);
    }
    public Date SetDate(String data) {
        String dateString = data;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public long dataDifInDaysLocal(String Date){
        Date Localdate = new Date();
        Date ALastDateD = SetDate(Date);
        LocalDate date1 = Localdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = ALastDateD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long daysDiff = ChronoUnit.DAYS.between(date1, date2);
        return daysDiff;
    }
}