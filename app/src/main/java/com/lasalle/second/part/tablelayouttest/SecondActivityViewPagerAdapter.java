package com.lasalle.second.part.tablelayouttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by albert.denova on 02/02/17.
 */

public class SecondActivityViewPagerAdapter extends FragmentPagerAdapter {

    public SecondActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return new FirstFragment();
        }
        else if(position == 1)
        {
            return new SecondFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
        {
            return "Tab 1";
        }
        else
        {
            return "Tab 2";
        }
    }
}
