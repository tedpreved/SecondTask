package com.mytsyk.yalantis.secondtask.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.ui.detail.DetailActivity;
import com.mytsyk.yalantis.secondtask.ui.home.fab.CustomFloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CustomFloatingActionButton mFab;


    private ImageView imShowDrawer;

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
        imShowDrawer = (ImageView) findViewById(R.id.activity_home_im_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.home_activity_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.activity_home_drawer);


        final String[] menuTitle = getResources().getStringArray(R.array.mass_menu_title);
        final DrawerMenuAdapter drawerMenuAdapter = new DrawerMenuAdapter(getApplicationContext(),
                mIconMass, menuTitle);

        mDrawerList.setAdapter(drawerMenuAdapter);

        imShowDrawer.setOnClickListener(showDrawerListener);
    }

    private void setUpTabs() {
        mViewPager = (ViewPager) findViewById(R.id.activity_home_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.activity_home_tab_layout);


        mFab = (CustomFloatingActionButton) findViewById(R.id.activity_home_fab);
        mFab.setOnClickListener(mFabClickListener);

        final InProgressFragment inProgressFragment = new InProgressFragment();
        inProgressFragment.setLaunchDetailCallback(mLaunchDetailsActivity);
        inProgressFragment.setFabController(fabController);

        final DoneFragment completeFragment = new DoneFragment();
        completeFragment.setLaunchDetailCallback(mLaunchDetailsActivity); //[Comment] Bad Activity -> Fragment communication
        //Use onAttach method
        completeFragment.setFabController(fabController);

        final NotDoneFragment notDoneFragment = new NotDoneFragment(); //[Comment] Use newInstance
        notDoneFragment.setLaunchDetailCallback(mLaunchDetailsActivity);
        notDoneFragment.setFabButton(mFab);

        final Fragment[] mFragmentList = {inProgressFragment, completeFragment, notDoneFragment};

        final SampleFragmentPagerAdapter pagerAdapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                getApplicationContext(), mFragmentList);

        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private HomeActivity.fabController fabController = new fabController() {
        @Override
        public void hide() {
            mFab.hide();
        }

        @Override
        public void show() {
            mFab.show();
        }
    };

    public interface fabController { //[Comment] BAD interface name.
        void hide();

        void show();
    }

    private View.OnClickListener mLaunchDetailsActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent detailActivity = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(detailActivity);
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

    private View.OnClickListener mFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
