package com.example.limeapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VP_Adapter extends RecyclerView.Adapter<VP_Adapter.ViewHolder>{
    ArrayList<ViePagerItem> viePagerItemsArrayList;

    public VP_Adapter(ArrayList<ViePagerItem> viePagerItemsArrayList) {
        this.viePagerItemsArrayList = viePagerItemsArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item,parent,false);

        return new ViewHolder(view);
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

        TextView StartDate;

        TextView EndDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
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
}
