package com.mytsyk.yalantis.secondtask.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.model.ItemTestData;
import com.mytsyk.yalantis.secondtask.ui.home.fab.CustomFloatingActionButton;
import com.mytsyk.yalantis.secondtask.ui.home.fab.ScrollDirectionListener;

import java.util.ArrayList;
import java.util.List;


public class NotDoneFragment extends Fragment {
    private ListView mLvNotDone;
    private CustomFloatingActionButton mFloatingActionButton;
    private List<ItemTestData> mDataInProgress;

    private OnLaunchDetailsListener mLaunchDetailListener;

    public static NotDoneFragment newInstance() {
        NotDoneFragment notDoneFragment = new NotDoneFragment();
        return notDoneFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mLaunchDetailListener = (OnLaunchDetailsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnLaunchDetailListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_not_done, container, false);
        initData();
        mLvNotDone = (ListView) view.findViewById(R.id.fragment_not_done_lv_not_done);
        NotDoneListViewAdapter notDoneListViewAdapter = new NotDoneListViewAdapter(getActivity(),
                mDataInProgress, mLaunchDetailListener);
        mLvNotDone.setAdapter(notDoneListViewAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mFloatingActionButton == null) return;
        mFloatingActionButton.attachToListView(mLvNotDone, scrollDirectionListener, onScrollListener);
    }

    private void initData() {
        mDataInProgress = new ArrayList<>();
        final String title = getString(R.string.test_title);
        final String address = getString(R.string.test_address);
        final String date = getString(R.string.test_date);
        for (int i = 0; i <= 10; i++) {
            mDataInProgress.add(new ItemTestData(title, address, date));
        }

    }

    public void setFabButton(CustomFloatingActionButton fabButton) {
        this.mFloatingActionButton = fabButton;
    }


    private ScrollDirectionListener scrollDirectionListener = new ScrollDirectionListener() {
        @Override
        public void onScrollDown() {

        }

        @Override
        public void onScrollUp() {

        }
    };

    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };
}
