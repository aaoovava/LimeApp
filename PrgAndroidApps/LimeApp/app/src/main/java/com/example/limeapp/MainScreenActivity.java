package com.example.limeapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import com.squareup.picasso.Picasso;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.ArrayList;

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


        if (user == null){
            toLogin();
        }
        else {
            progressBar4.setVisibility(View.VISIBLE);
            users.child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String Uname,Sname;
                    String usName = snapshot.child("name").getValue().toString();
                    String AfirstDate = snapshot.child("aboniment_start_date").getValue().toString();
                    String ALastDate = snapshot.child("aboniment_end_date").getValue().toString();
                    String PName = snapshot.child("personal_t_name").getValue().toString();
                    String PfirstDate = snapshot.child("personal_t_start_date").getValue().toString();
                    String PLastDate = snapshot.child("personal_t_end_date").getValue().toString();
                    try {
                        String[] words = Spase(usName);
                        Uname = words[0];
                        Sname = words[1];
                    }catch (Exception e){
                        Uname = usName;
                        Sname = "";
                    }

                    viePagerItemArrayList = new ArrayList<>();
                    String image = snapshot.child("image").getValue().toString();
                    ViePagerItem AviePagerItem = new ViePagerItem(Uname, Sname, "Абонемент","Дата початку дії: ","Дата закінчення дії: ",AfirstDate,ALastDate,image);
                    viePagerItemArrayList.add(AviePagerItem);
                    ViePagerItem PviePagerItem = new ViePagerItem(Uname, Sname,"Групові заняття","Кількість занять: ", "Використана кількість: ",PfirstDate,PLastDate,image);

                    viePagerItemArrayList.add(PviePagerItem);


                    VP_Adapter vp_adapter = new VP_Adapter(viePagerItemArrayList);



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
}
