package com.football.cal.model;

import android.os.Parcel;

public class BaseCalendar extends BaseModel {

    public String title, text;
    public int imageMain;

    public BaseCalendar(String title, String text, int imageMain) {
        this.title = title;
        this.text = text;
        this.imageMain = imageMain;

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.title);
        dest.writeString(this.text);
        dest.writeInt(this.imageMain);
    }

    protected BaseCalendar(Parcel in) {
        super(in);
        this.title = in.readString();
        this.text = in.readString();
        this.imageMain = in.readInt();
    }

    public static final Creator<BaseCalendar> CREATOR = new Creator<BaseCalendar>() {
        @Override
        public BaseCalendar createFromParcel(Parcel source) {
            return new BaseCalendar(source);
        }

        @Override
        public BaseCalendar[] newArray(int size) {
            return new BaseCalendar[size];
        }
    };

}
