package com.example.limeapp;

import android.graphics.drawable.Drawable;

public class ViePagerItem {
    String Uname,Sname,AorB_name,start_date,end_date,Pimg,StartDate,EndDate;
    Drawable ButImage,StatusImage;


    public ViePagerItem(String uname, String sname, String aorB_name, String start_date, String end_date, String pimg, String startDate, String endDate, Drawable butImage, Drawable statusImage) {
        Uname = uname;
        Sname = sname;
        AorB_name = aorB_name;
        this.start_date = start_date;
        this.end_date = end_date;
        Pimg = pimg;
        StartDate = startDate;
        EndDate = endDate;
        ButImage = butImage;
        StatusImage = statusImage;
    }
}
