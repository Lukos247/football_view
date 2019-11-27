package com.football.cal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatchHolder extends RecyclerView.ViewHolder {
    TextView time,name1,name2;
    ImageView logo1;

    public MatchHolder(@NonNull View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        name1 = itemView.findViewById(R.id.teamOne);
        name2 = itemView.findViewById(R.id.teamTwo);
        logo1 = itemView.findViewById(R.id.logo2);

    }
}
