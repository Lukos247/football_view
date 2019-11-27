package com.football.cal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TitleHolder extends RecyclerView.ViewHolder {
    TextView title;

    public TitleHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }

}
