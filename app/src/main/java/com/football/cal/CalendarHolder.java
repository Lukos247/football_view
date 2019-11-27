package com.football.cal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CalendarHolder extends RecyclerView.ViewHolder{

     TextView title,textNews;
     ImageView image;

    public CalendarHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.newsTitle);
        textNews = itemView.findViewById(R.id.newsContent);
        image = itemView.findViewById(R.id.newsImage);

    }

}
