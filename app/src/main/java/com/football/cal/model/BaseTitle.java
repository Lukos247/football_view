package com.football.cal.model;

import android.os.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BaseTitle extends BaseModel {
    private Date date;

    public BaseTitle(Date date) {
        this.date = date;
    }

    public String getTitle(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("EEEE, MMMM dd", Locale.getDefault());
        return formatForDateNow.format(date);
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeSerializable(this.date);
    }

    protected BaseTitle(Parcel in) {
        super(in);
        this.date = (Date) in.readSerializable();
    }

    public static final Creator<BaseTitle> CREATOR = new Creator<BaseTitle>() {
        @Override
        public BaseTitle createFromParcel(Parcel source) {
            return new BaseTitle(source);
        }

        @Override
        public BaseTitle[] newArray(int size) {
            return new BaseTitle[size];
        }
    };
}
