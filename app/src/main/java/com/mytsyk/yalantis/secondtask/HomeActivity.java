package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mytsyk.yalantis.secondtask.fab.CustomFloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CustomFloatingActionButton fabNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpTabs();
    }

    private void setUpTabs(){
        mViewPager=(ViewPager)findViewById(R.id.activity_home_view_pager);
        mTabLayout=(TabLayout)findViewById(R.id.activity_home_tab_layout);

        SampleFragmentPagerAdapter pagerAdapter=new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                                                                               getApplicationContext());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public View getFab(){
        fabNew=(CustomFloatingActionButton)findViewById(R.id.activity_home_fab);
        return fabNew;
    }
}
