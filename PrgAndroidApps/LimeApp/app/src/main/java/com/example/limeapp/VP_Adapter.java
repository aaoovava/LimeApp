package com.example.limeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VP_Adapter extends RecyclerView.Adapter<VP_Adapter.ViewHolder> {
    FirebaseDatabase db;
    private List<ViePagerItem> viePagerItemsArrayList;
    private Context context;


    public VP_Adapter(ArrayList<ViePagerItem> viePagerItemsArrayList, Context context) {
        this.viePagerItemsArrayList = viePagerItemsArrayList;
        this.context = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        db = FirebaseDatabase.getInstance();
        DatabaseReference users = db.getReference("users");
        String userId = user.getUid();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        users.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String AfirstDate = snapshot.child("aboniment_start_date").getValue().toString();
                String ALastDate = snapshot.child("aboniment_end_date").getValue().toString();
                int Astatus = Integer.parseInt(snapshot.child("aboniment_status").getValue().toString());
                int Gstatus = Integer.parseInt(snapshot.child("group_t_status").getValue().toString());
                viewHolder.ButM.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int dateCheck = Astatus;
                        int position = viewHolder.getAdapterPosition();
                        handleButton1Click(position,Astatus);
                    }
                });
                viewHolder.But2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int dateCheck = Gstatus;
                        int position = viewHolder.getAdapterPosition();
                        handleButton2Click(position,dateCheck);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViePagerItem pagerItem = viePagerItemsArrayList.get(position);
        Picasso.get().load(pagerItem.Pimg).into(holder.circleImageView);
        holder.Title_txt.setText(pagerItem.AorB_name);
        holder.Start_date.setText(pagerItem.start_date);
        holder.End_date.setText(pagerItem.end_date);
        holder.UName.setText(pagerItem.Uname);
        holder.SName.setText(pagerItem.Sname);
        holder.StartDate.setText(pagerItem.StartDate);
        holder.EndDate.setText(pagerItem.EndDate);
        holder.ButM.setImageDrawable(pagerItem.ButImage);
        holder.StatusBut.setImageDrawable(pagerItem.StatusImage);
        holder.But2.setImageDrawable(pagerItem.ButImage2);
        holder.CountOfGT.setText(pagerItem.CountOfGT);



    }

    @Override
    public int getItemCount() {
        return viePagerItemsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView Title_txt;
        TextView Start_date;
        TextView End_date;
        TextView UName;
        TextView SName;

        TextView CountOfGT;
        ImageView ButM;
        ImageView But2;

        ImageView StatusBut;



        TextView StartDate;

        TextView EndDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            But2 = itemView.findViewById(R.id.But2);
            CountOfGT = itemView.findViewById(R.id.CountOfGT);
            StatusBut = itemView.findViewById(R.id.StatusBut);
            ButM = itemView.findViewById(R.id.ButM);
            circleImageView = itemView.findViewById(R.id.imageView20);
            Title_txt = itemView.findViewById(R.id.abb);
            Start_date = itemView.findViewById(R.id.firstDate);
            End_date = itemView.findViewById(R.id.lastDate);
            UName = itemView.findViewById(R.id.UName);
            SName = itemView.findViewById(R.id.Sname);
            StartDate = itemView.findViewById(R.id.SatrtDate);
            EndDate = itemView.findViewById(R.id.EndDate);

        }
    }
    public void handleButton1Click(int position,int DataCheck) {
        if (DataCheck == 1 || position == 1){
        switch (position) {
            case 0:
                toAFreeze();
                break;
            case 1:
                toTable();
                break;

        }}else if (DataCheck == 3) {
            Toast toast = Toast.makeText(context,"Відсутній абонемент",Toast.LENGTH_SHORT);
            toast.show();
        } else if (DataCheck == 2) {
            Toast toast = Toast.makeText(context,"Абонемент вже заморожений",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void handleButton2Click(int position,int DataCheck) {
        if (DataCheck == 1 ){
            switch (position) {
                case 0:
                    break;
                case 1:
                    toGFreeze();
                    break;

            }}else if (DataCheck == 3){
            Toast toast = Toast.makeText(context,"Відсутній абонемент",Toast.LENGTH_SHORT);
            toast.show();
        } else if (DataCheck == 2) {
            Toast toast = Toast.makeText(context,"Абонемент вже заморожений",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void toAFreeze(){
        Intent intent = new Intent(context, AFreeze.class);
        context.startActivity(intent);

    }public void toTable(){
        Intent intent = new Intent(context, table.class);
        context.startActivity(intent);
    }
    public void toGFreeze(){
        Intent intent = new Intent(context,GFreeze.class);
        context.startActivity(intent);
    }



}

