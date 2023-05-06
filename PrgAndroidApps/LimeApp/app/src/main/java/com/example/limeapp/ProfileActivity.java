package com.example.limeapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    FirebaseDatabase db;
    private CircleImageView circleImageView;
    private Uri imageUri;
    private String myUri = "";
    private StorageTask uploadTask;
    private StorageReference storageProfileReference;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();


        setContentView(R.layout.profile_activity);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.green));
        ImageView DocBut = findViewById(R.id.DocButPrise);
        ImageView PriseBut = findViewById(R.id.priseButProf);
        EditText nameEdit = findViewById(R.id.editName);
        ImageView LogOut = findViewById(R.id.imageView36);
        ImageView SavedButton = findViewById(R.id.saved_button);
        circleImageView = findViewById(R.id.profile_image);
        ImageView addImage = findViewById(R.id.imageView34);

        storageProfileReference = FirebaseStorage.getInstance().getReference().child("Profile Pic");

        SavedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadProfileImage();
                HashMap<String,Object> j  = new HashMap<>();
                j.put("name",nameEdit.getText().toString());
                users.child(auth.getCurrentUser().getUid()).updateChildren(j);

            }
        });
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    CropImage.activity().setAspectRatio(1, 1).start(ProfileActivity.this);
                    uploadProfileImage();
                    HashMap<String, Object> j = new HashMap<>();
                    j.put("name", nameEdit.getText().toString());
                    users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });



        users.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String usName = snapshot.child("name").getValue().toString();
                nameEdit.setText(usName);
                if (snapshot.hasChild("image")){
                    String image = snapshot.child("image").getValue().toString();
                    Picasso.get().load(image).into(circleImageView);
                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                toLogin();
            }
        });
        PriseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPrise();
            }
        });
        DocBut.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                uploadProfileImage();
                HashMap<String,Object> j  = new HashMap<>();
                j.put("name",nameEdit.getText().toString());
                users.child(auth.getCurrentUser().getUid()).updateChildren(j);
                toMainScreen();
            }
        });

    }
    void toMainScreen(){
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }
    void toLogin(){
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }
    void toPrise(){
        Intent intent = new Intent(this, PriseScreen.class);
        startActivity(intent);
    }
    void uploadProfileImage(){

    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseUser user = auth.getCurrentUser();
    db = FirebaseDatabase.getInstance();
    DatabaseReference users = db.getReference().child("users");
    String userId = user.getUid();


    final ProgressDialog progressDialog = new ProgressDialog(this);
    progressDialog.setTitle("Set your profile");
    progressDialog.setMessage("Pleas wait");
    progressDialog.show();

    if (imageUri != null){
        final StorageReference fileRef = storageProfileReference.child(auth.getCurrentUser().getUid() + ".jpg");
        uploadTask = fileRef.putFile(imageUri);

        uploadTask.continueWithTask(new Continuation() {
            @Override
            public Object then(@NonNull Task task) throws Exception {
                if (!task.isSuccessful()){
                    task.getException();
                }
                return fileRef.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUrl =  task.getResult();
                    myUri = downloadUrl.toString();

                    HashMap<String, Object> userMap = new HashMap<>();
                    userMap.put("image", myUri);
                    users.child(auth.getCurrentUser().getUid()).updateChildren(userMap);
                    progressDialog.dismiss();
                }
            }
        });
    }else {
        progressDialog.dismiss();
        Toast toast = Toast.makeText(ProfileActivity.this,"Не вибрано фото",Toast.LENGTH_LONG);
    }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            imageUri = result.getUri();

            circleImageView.setImageURI(imageUri);

            Toast.makeText(ProfileActivity.this,"Помилка",Toast.LENGTH_LONG);

    }
}
