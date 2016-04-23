package com.mytsyk.yalantis.secondtask.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.home.fab.CustomFloatingActionButton;
import com.mytsyk.yalantis.secondtask.home.fab.ScrollDirectionListener;


public class NotDoneFragment extends Fragment {
    private ListView mLvNotDone;
    private CustomFloatingActionButton mFloatingActionButton;
    private View.OnClickListener mLaunchDetailCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_not_done, container, false);
        mLvNotDone = (ListView) view.findViewById(R.id.fragment_not_done_lv_not_done);
        NotDoneListViewAdapter notDoneListViewAdapter = new NotDoneListViewAdapter(getActivity(), mLaunchDetailCallback);
        mLvNotDone.setAdapter(notDoneListViewAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mFloatingActionButton == null) return;
        mFloatingActionButton.attachToListView(mLvNotDone, scrollDirectionListener, onScrollListener);
    }

    public void setFabButton(CustomFloatingActionButton fabButton) {
        this.mFloatingActionButton = fabButton;
    }

    public void setLaunchDetailCallback(View.OnClickListener callback) {
        this.mLaunchDetailCallback = callback;
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
