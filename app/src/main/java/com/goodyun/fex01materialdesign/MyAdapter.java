package com.goodyun.fex01materialdesign;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alfo6-19 on 2018-03-14.
 */

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] frags = new Fragment[3];
    String[] titles = new String[]{"Home","Theme","Talk"};

    public MyAdapter(FragmentManager fm) {

        super(fm);

        frags[0] = new Page1_Fragment();
        frags[1] = new Page2_Fragment();
        frags[2] = new Page3_Fragment();
    }

    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
