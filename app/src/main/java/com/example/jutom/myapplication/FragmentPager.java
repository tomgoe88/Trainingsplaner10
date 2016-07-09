package com.example.jutom.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jutom on 28.06.2016.
 */
public class FragmentPager extends FragmentPagerAdapter {
    private String[] titles;
    private List<Fragment> fragments;
    int fcount;

    public FragmentPager(FragmentManager fm, List<Fragment> fragmentList, String[] title){
        super(fm);
        this.fragments= fragmentList;
        this.titles= title;
        this.fcount= fragments.size();
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fcount;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String tabtitle= titles[position];
        return tabtitle;
    }
}
