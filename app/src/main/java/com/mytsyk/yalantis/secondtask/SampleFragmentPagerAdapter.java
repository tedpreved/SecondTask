package com.mytsyk.yalantis.secondtask;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[];
    private Context context;
    private Fragment[] mFragmentList={new InProgressFragment(),new InProgressFragment(),new NotDoneFragment()};

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles=context.getResources().getStringArray(R.array.home_activity_tab_name);
        /*mFragmentList[0]=new InProgressFragment();
        mFragmentList[1]=new InProgressFragment();
        mFragmentList[2]=new InProgressFragment();*/
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
        return tabTitles[position];
    }
}
