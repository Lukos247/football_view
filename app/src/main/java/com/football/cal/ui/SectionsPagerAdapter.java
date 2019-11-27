package com.football.cal.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.football.cal.PHP;
import com.football.cal.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            default: return PlaceholderFragment.newInstance(PHP.apl());
            case 1: return PlaceholderFragment.newInstance(PHP.laliga());
           // case 2: return PlaceholderFragment.newInstance(PHP.seriea());
        }

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}