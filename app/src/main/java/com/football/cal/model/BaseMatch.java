package com.football.cal.model;

import android.os.Parcel;

public class BaseMatch extends BaseModel{
    public String date, nameTeamOne, nameTeamTwo;
    public int logo1, logo2;

    public BaseMatch(String date, String nameTeamOne, int logo1, String nameTeamTwo) {
        this.date = date;
        this.nameTeamOne = nameTeamOne;
        this.nameTeamTwo = nameTeamTwo;
        this.logo1 = logo1;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.date);
        dest.writeString(this.nameTeamOne);
        dest.writeString(this.nameTeamTwo);
        dest.writeInt(this.logo1);
    }

    protected BaseMatch(Parcel in) {
        super(in);
        this.date = in.readString();
        this.nameTeamOne = in.readString();
        this.nameTeamTwo = in.readString();
        this.logo1 = in.readInt();
    }

    public static final Creator<BaseMatch> CREATOR = new Creator<BaseMatch>() {
        @Override
        public BaseMatch createFromParcel(Parcel source) {
            return new BaseMatch(source);
        }

        @Override
        public BaseMatch[] newArray(int size) {
            return new BaseMatch[size];
        }
    };
}
