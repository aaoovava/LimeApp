package com.example.limeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Freeze extends AppCompatActivity {
    FirebaseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freeze);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));
        TextView countOfU = findViewById(R.id.CountOfU);
        TextView countOfD = findViewById(R.id.CountOfD);
        EditText dataEdit = findViewById(R.id.DataEdit);
        ImageView closeBut = findViewById(R.id.CloseBut);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();

        users.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Dres = (snapshot.child("freeze_days").getValue().toString()) + " дн";
                countOfD.setText(Dres);
                countOfU.setText("0 дн");

                dataEdit.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        int Data = Integer.parseInt(snapshot.child("freeze_days").getValue().toString());
                        if (s.toString() != ""){
                            closeBut.setVisibility(View.VISIBLE);
                            closeBut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    closeKeyboard();
                                    closeBut.setVisibility(View.INVISIBLE);
                                }
                            });
                        }
                        String Ures = s.toString() + " дн";
                        countOfU.setText(Ures);
                        try {
                            String a = String.valueOf(Data - Integer.parseInt(s.toString()) +" дн");
                            countOfD.setText(a);
                        }catch (Exception e){
                            String Dres = String.valueOf(Data) + " дн";
                            countOfD.setText(Dres);
                        }
                        try {


                            if (Integer.parseInt(s.toString()) > Data) {
                                dataEdit.setText("");
                            }}catch (Exception e){

                        }

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}