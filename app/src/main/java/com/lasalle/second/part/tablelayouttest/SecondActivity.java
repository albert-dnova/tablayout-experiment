package com.lasalle.second.part.tablelayouttest;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.second_activity_tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.second_activity_view_pager);
        viewPager.setAdapter(new SecondActivityViewPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
