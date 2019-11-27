package com.football.cal;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.football.cal.ui.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = findViewById(R.id.view_pager);

        findViewById(R.id.action_matches).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        findViewById(R.id.action_news).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(1);
            }
        });

       // text1 = findViewById(R.id.nameApl);
       // text2 = findViewById(R.id.nameLaLiga);
       // text3 = findViewById(R.id.nameSerieA);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                style(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void style(int pos) {
      //  text1.setTextColor(Color.parseColor("#808080"));
      //  text2.setTextColor(Color.parseColor("#808080"));
      //  text3.setTextColor(Color.parseColor("#808080"));
      //  switch (pos){
      //      default: text1.setTextColor(Color.parseColor("#2bbd7e")); break;
      //      case 1: text2.setTextColor(Color.parseColor("#2bbd7e")); break;
      //      case 2: text3.setTextColor(Color.parseColor("#2bbd7e")); break;
      //  }
    }
}