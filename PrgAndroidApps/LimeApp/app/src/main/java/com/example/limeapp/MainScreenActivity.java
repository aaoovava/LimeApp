package com.example.limeapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class MainScreenActivity extends AppCompatActivity {
    FirebaseDatabase db;
    private String name;
    ArrayList<ViePagerItem>viePagerItemArrayList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));

        ImageView profBut = (ImageView) findViewById(R.id.prof_bot);
        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        SpringDotsIndicator dotsIndicator = findViewById(R.id.Adapter);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4);
        ImageView priseBut = findViewById(R.id.priseBut);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();

            try {


                if (user == null) {
                    toLogin();
                } else {
                    progressBar4.setVisibility(View.VISIBLE);
                    int data;
                    users.child(userId).addValueEventListener(new ValueEventListener() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String Uname, Sname;
                            String usName = snapshot.child("name").getValue().toString();
                            String AfirstDate = snapshot.child("aboniment_start_date").getValue().toString();
                            String ALastDate = snapshot.child("aboniment_end_date").getValue().toString();
                            String PName = snapshot.child("aboniment_status").getValue().toString();
                            String PfirstDate = snapshot.child("group_t_start_date").getValue().toString();
                            String PLastDate = snapshot.child("group_t_end_date").getValue().toString();
                            String AFreezeDate = snapshot.child("afreeze_date").getValue().toString();
                            String GFreezeDate = snapshot.child("group_t_end_date").getValue().toString();
                            int Astatus = Integer.parseInt(snapshot.child("aboniment_status").getValue().toString());
                            int Gstatus = Integer.parseInt(snapshot.child("group_t_status").getValue().toString());

                            //Check status methods

                            if (Astatus == 1){
                                Date Localdate = new Date();
                                Date ALastDateD = SetDate(ALastDate);
                                int comparison = Localdate.compareTo(ALastDateD);
                                if (comparison < 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("aboniment_status","1");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }else if (comparison > 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("aboniment_status","3");
                                    j.put("aboniment_start_date","немає");
                                    j.put("aboniment_end_date","немає");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                            } else if (Astatus == 2) {
                                Date LocalDate = new Date();
                                Date AFreezeDateD = SetDate(AFreezeDate);
                                int comparison = LocalDate.compareTo(AFreezeDateD);
                                if (comparison >= 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("aboniment_status","1");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                                else {
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("aboniment_status","2");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                            }
                            if (Gstatus == 1){
                                Date Localdate = new Date();
                                Date GLastDateD = SetDate(PLastDate);
                                int comparison = Localdate.compareTo(GLastDateD);
                                if (comparison < 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("group_t_status","1");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }else if (comparison > 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("group_t_status","3");
                                    j.put("group_t_start_date","немає");
                                    j.put("group_t_end_date","немає");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                            } else if (Gstatus == 2) {
                                Date LocalDate = new Date();
                                Date GFreezeDateD = SetDate(GFreezeDate);
                                int comparison = LocalDate.compareTo(GFreezeDateD);
                                if (comparison >= 0){
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("group_t_status","1");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                                else {
                                    HashMap<String,Object> j  = new HashMap<>();
                                    j.put("group_t_status","2");
                                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                                }
                            }

                            try {
                                String[] words = Spase(usName);

                                Uname = words[0];
                                Sname = words[1];
                            } catch (Exception e) {
                                Uname = usName;
                                Sname = "";
                            }

                            viePagerItemArrayList = new ArrayList<>();
                            String image = "https://firebasestorage.googleapis.com/v0/b/lime-pdb.appspot.com/o/user-profile-4255%201.png?alt=media&token=d95cec80-d997-4d83-8c6f-30c8e98f3edb";
                            try {
                                image = snapshot.child("image").getValue().toString();
                            } catch (Exception e) {
                                image = "https://firebasestorage.googleapis.com/v0/b/lime-pdb.appspot.com/o/user-profile-4255%201.png?alt=media&token=d95cec80-d997-4d83-8c6f-30c8e98f3edb";
                            }
                            ViePagerItem AviePagerItem = new ViePagerItem(Uname, Sname, "Абонемент", "Дата початку дії: ", "Дата закінчення дії: ", image, AfirstDate, ALastDate,"", getResources().getDrawable(R.drawable.freeze),getResources().getDrawable(R.drawable.rectangle_7oki), getStatus(Astatus));
                            viePagerItemArrayList.add(AviePagerItem);

                            ViePagerItem PviePagerItem = new ViePagerItem(Uname, Sname, "Групові заняття", "Дата початку дії: ", "Дата закінчення дії: ", image, PfirstDate, PLastDate,snapshot.child("countOfGT").getValue().toString(), getResources().getDrawable(R.drawable.group_18),getResources().getDrawable(R.drawable.freeze),getStatus(Gstatus));

                            viePagerItemArrayList.add(PviePagerItem);


                            VP_Adapter vp_adapter = new VP_Adapter(viePagerItemArrayList, MainScreenActivity.this);


                            viewPager2.setAdapter(vp_adapter);
                            viewPager2.setClipToPadding(false);
                            viewPager2.setClipChildren(false);
                            viewPager2.setOffscreenPageLimit(2);
                            viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
                            dotsIndicator.attachTo(viewPager2);
                            progressBar4.setVisibility(View.INVISIBLE);
                            dotsIndicator.setVisibility(View.VISIBLE);


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
                    priseBut.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            toPrise();
                        }
                    });


                }
            }catch (Exception e){
                toLogin();
            }

    }
    public String[] Spase(String txt){

        String[] words = String.format(txt).split(" ");

        return words;
    }
    void toPrise(){
        Intent intent = new Intent(this, PriseScreen.class);
        startActivity(intent);
    }
    void toProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    void toLogin(){
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }

    Drawable getStatus (int status){
        Drawable res = null;
        switch (status){
            case 1:
                res = getResources().getDrawable(R.drawable.status_1);
                break;
            case 2:
                res = getResources().getDrawable(R.drawable.status_2);
                break;
            case 3:
                res = getResources().getDrawable(R.drawable.status_3);
                break;
        }
        return res;
    }
    public  Date SetDate(String data) {
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
    public static String formatDate(Date date) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String dateString = format.format(date);
        return dateString;
    }
    }


