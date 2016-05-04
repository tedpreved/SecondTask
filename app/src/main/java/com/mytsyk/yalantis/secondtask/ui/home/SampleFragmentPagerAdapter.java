package com.mytsyk.yalantis.secondtask.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String mTabTitles[];
    private Fragment[] mFragmentList;

    public SampleFragmentPagerAdapter(FragmentManager fm, String[] arrayTitles, Fragment[] fragments) {
        super(fm);
        this.mFragmentList = fragments;
        this.mTabTitles = arrayTitles;
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.length;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList[position];
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }


}
