package com.football.cal;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.football.cal.model.BaseMatch;
import com.football.cal.model.BaseModel;
import com.football.cal.model.BaseTitle;
import com.football.cal.model.BaseCalendar;

import java.util.ArrayList;

public class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<BaseModel> array;
    BaseListener listener;

    public BaseAdapter(ArrayList<BaseModel> array) {
        this.array = array;
    }

    public void setBaseListener(BaseListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        if (viewType == 0) {
            return new TitleHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_title, parent, false));
        } else if (viewType == 1) {
            return new MatchHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_match, parent, false));
        } else
            return new CalendarHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_calendar, parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==0){

            BaseTitle title = (BaseTitle)array.get(position);
            TitleHolder h = (TitleHolder)holder;
            h.title.setText(title.getTitle());

        } else if(getItemViewType(position)==1){
            BaseMatch match = (BaseMatch)array.get(position);
            MatchHolder h = (MatchHolder)holder;
            h.time.setText(match.date);
            h.name1.setText(match.nameTeamOne);
            h.name2.setText(match.nameTeamTwo);
            h.logo1.setImageResource(match.logo1);
        }
        else{

           BaseCalendar m = (BaseCalendar)array.get(position);
           CalendarHolder h = (CalendarHolder)holder;
           h.title.setText(m.title);
           h.textNews.setText(m.text);
           h.image.setImageResource(m.imageMain);

        }
    }


    @Override
    public int getItemViewType(int position) {

      if(array.get(position) instanceof BaseTitle){
          return 0;
      }
      else if(array.get(position) instanceof BaseMatch){
          return 1;
      }
        else return 2;
    }

    @Override
    public int getItemCount() {
        return array!=null?array.size():0;
    }
}
