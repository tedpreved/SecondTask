package com.mytsyk.yalantis.secondtask.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.ui.detail.DetailActivity;
import com.mytsyk.yalantis.secondtask.ui.home.fab.CustomFloatingActionButton;

public class HomeActivity extends AppCompatActivity implements OnLaunchDetailsListener,
        FabChangeVisibilityListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CustomFloatingActionButton mFab;


    private ImageView imShowDrawer;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpTabs();
        initDrawer();
    }

    private void initDrawer() {
        imShowDrawer = (ImageView) findViewById(R.id.activity_home_im_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.home_activity_drawer_layout);

        mNavigationView = (NavigationView) findViewById(R.id.activity_home_navigation_view);

        mNavigationView.setNavigationItemSelectedListener(mNavigationDrawerListener);

        imShowDrawer.setOnClickListener(showDrawerListener);
    }

    private void setUpTabs() {
        mViewPager = (ViewPager) findViewById(R.id.activity_home_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.activity_home_tab_layout);


        mFab = (CustomFloatingActionButton) findViewById(R.id.activity_home_fab);
        mFab.setOnClickListener(mOnFabClickListener);

        final InProgressFragment inProgressFragment = InProgressFragment.newInstance();

        final DoneFragment completeFragment = DoneFragment.newInstance();

        final NotDoneFragment notDoneFragment = NotDoneFragment.newInstance();
        notDoneFragment.setFabButton(mFab);

        final Fragment[] mFragmentList = {inProgressFragment, completeFragment, notDoneFragment};

        final String[] arrayTitle = getResources().getStringArray(R.array.home_activity_tab_name);
        final SampleFragmentPagerAdapter pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                arrayTitle, mFragmentList);

        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void hideFab() {
        if (mFab.mVisible) mFab.hide();
    }

    @Override
    public void showFab() {
        if (!mFab.mVisible) mFab.show();
    }

    @Override
    public void onDetailClick(View view) {
        Intent detailActivity = new Intent(getApplicationContext(), DetailActivity.class);
        startActivity(detailActivity);
    }


    private NavigationView.OnNavigationItemSelectedListener mNavigationDrawerListener = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {

            if (menuItem.isChecked()) menuItem.setChecked(false);
            else menuItem.setChecked(true);

            mDrawerLayout.closeDrawers();

            switch (menuItem.getItemId()) {
                case R.id.menu_all_orders:
                    return true;
                case R.id.menu_map:
                    return true;
                default:
                    return true;
            }
        }
    };

    private View.OnClickListener showDrawerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mDrawerLayout == null) return;
            mDrawerLayout = (DrawerLayout) findViewById(R.id.home_activity_drawer_layout);
            mDrawerLayout.openDrawer(Gravity.LEFT);
        }
    };

    private View.OnClickListener mOnFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };
}
