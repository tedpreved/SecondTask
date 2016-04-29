package com.mytsyk.yalantis.secondtask.ui.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mytsyk.yalantis.secondtask.R;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String mTabTitles[];
    private Context mContext; //[Comment] Unused
    private Fragment[] mFragmentList;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context, Fragment[] fragments) {
        super(fm);
        this.mContext = context;
        this.mFragmentList = fragments; //[Comment] Unnecessary this
        mTabTitles = context.getResources().getStringArray(R.array.home_activity_tab_name);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
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
