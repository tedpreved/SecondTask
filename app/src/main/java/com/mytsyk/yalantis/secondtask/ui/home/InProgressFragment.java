package com.mytsyk.yalantis.secondtask.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.model.ItemTestData;
import com.mytsyk.yalantis.secondtask.ui.home.fab.CustomFloatingActionButton;

import java.util.ArrayList;


public class InProgressFragment extends Fragment {
    private RecyclerView mRvInProgress;
    private CustomFloatingActionButton mFab;
    private HomeActivity.fabController mFabController;
    private View.OnClickListener mLaunchDetailCallback;
    private ArrayList<ItemTestData> mDataInProgress; //[Comment] Use abstraction instead of realization

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_in_progress, container, false);
        initData();
        mRvInProgress = (RecyclerView) view.findViewById(R.id.rv_in_progress);
        mRvInProgress.setHasFixedSize(true);
        mRvInProgress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        InProgressAndDoneAdapter inProgressAndDoneAdapter = new InProgressAndDoneAdapter(mDataInProgress, mLaunchDetailCallback);
        mRvInProgress.setAdapter(inProgressAndDoneAdapter);

        mFab = (CustomFloatingActionButton) getActivity().findViewById(R.id.activity_home_fab); //[Comment] You don't need this object in fragment
        mRvInProgress.addOnScrollListener(onScrollListener);

        return view;
    }

    public void setFabController(HomeActivity.fabController mFabController) {
        this.mFabController = mFabController; //[Comment] wrong argument name
    }

    public void setLaunchDetailCallback(View.OnClickListener callback) {
        this.mLaunchDetailCallback = callback;
    }

    private void initData() {
        mDataInProgress = new ArrayList<>();
        final String title = getString(R.string.test_title);
        final String address = getString(R.string.test_address);
        final String date = getString(R.string.test_date);
        final String countDay = getString(R.string.test_count_day);
        for (int i = 0; i <= 10; i++) {
            mDataInProgress.add(new ItemTestData(title, address, date, countDay));
        }

    }

    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (mFabController == null) return;
            if (dy > 0 && mFab.mVisible) mFabController.hide();

            if (dy < 0 && !mFab.mVisible) mFabController.show();
        }
    };
}
