package com.example.limeapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VP_Adapter extends RecyclerView.Adapter<VP_Adapter.ViewHolder> {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.ButM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                handleButtonClick(position);
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
        ImageView ButM;


        TextView StartDate;

        TextView EndDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
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
    public void handleButtonClick(int position) {
        switch (position) {
            case 0:
                toFreeze();
                break;
            case 1:
                toTable();
                break;

        }
    }
    public void toFreeze(){
        Intent intent = new Intent(context, Freeze.class);
        context.startActivity(intent);
    }public void toTable(){
        Intent intent = new Intent(context, ProfileActivity.class);
        context.startActivity(intent);
    }

}

