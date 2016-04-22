package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.mytsyk.yalantis.secondtask.fab.CustomFloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CustomFloatingActionButton fab;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private int[] mIconMass = {R.drawable.ic_issues,
            R.drawable.ic_map};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpTabs();
        initDrawer();
    }

    private void initDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.home_activity_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.activity_home_drawer);


        final String[] menuTitle = getResources().getStringArray(R.array.mass_menu_title);
        final DrawerMenuAdapter drawerMenuAdapter = new DrawerMenuAdapter(getApplicationContext(),
                mIconMass,menuTitle);

        mDrawerList.setAdapter(drawerMenuAdapter);
    }

    private void setUpTabs() {
        mViewPager = (ViewPager) findViewById(R.id.activity_home_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.activity_home_tab_layout);


        fab = (CustomFloatingActionButton) findViewById(R.id.activity_home_fab);

        final InProgressFragment inProgressFragment = new InProgressFragment();
        inProgressFragment.setFabController(fabController);

        final InProgressFragment completeFragment = new InProgressFragment();
        completeFragment.setFabController(fabController);

        final NotDoneFragment notDoneFragment = new NotDoneFragment();
        notDoneFragment.setFabButton(fab);

        final Fragment[] mFragmentList = {inProgressFragment, completeFragment, notDoneFragment};

        final SampleFragmentPagerAdapter pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                getApplicationContext(), mFragmentList);

        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private HomeActivity.fabController fabController = new fabController() {
        @Override
        public void hide() {
            fab.hide();
        }

        @Override
        public void show() {
            fab.show();
        }
    };

    public interface fabController {
        void hide();
        void show();
    }
}
