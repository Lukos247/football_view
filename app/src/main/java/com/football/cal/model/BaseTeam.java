package com.football.cal.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseTeam implements Parcelable {
    public String name;

    public BaseTeam(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected BaseTeam(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<BaseTeam> CREATOR = new Parcelable.Creator<BaseTeam>() {
        @Override
        public BaseTeam createFromParcel(Parcel source) {
            return new BaseTeam(source);
        }

        @Override
        public BaseTeam[] newArray(int size) {
            return new BaseTeam[size];
        }
    };
}
