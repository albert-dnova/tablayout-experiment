package com.lasalle.second.part.tablelayouttest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.main_activity_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addOnTabSelectedListener(this);

        displayFragment(new FirstFragment());

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.activity_main_floating_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        // Ignore
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if(tab.getPosition() == 0) {
            displayFragment(new FirstFragment());
        }
        else if(tab.getPosition() == 1)
        {
            displayFragment(new SecondFragment());
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        // Ignore
    }

    private void displayFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        List<Fragment> fragmentList = fragmentManager.getFragments();
        if((fragmentList != null) && (fragmentList.size() > 0))
        {
            fragmentTransaction.replace(R.id.main_activity_frame_layout, fragment);
        }
        else
        {
            fragmentTransaction.add(R.id.main_activity_frame_layout, fragment);
        }

        fragmentTransaction.commit();
    }
}
