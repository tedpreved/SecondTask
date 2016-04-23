package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytsyk.yalantis.secondtask.fab.CustomFloatingActionButton;


public class InProgressFragment extends Fragment {
    private RecyclerView mRvInProgress;
    private CustomFloatingActionButton mFab;
    private HomeActivity.fabController mFabController;
    private View.OnClickListener mLaunchDetailCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_in_progress, container, false);

        mRvInProgress = (RecyclerView) view.findViewById(R.id.rv_in_progress);
        mRvInProgress.setHasFixedSize(true);
        mRvInProgress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        InProgressAdapter inProgressAdapter = new InProgressAdapter(mLaunchDetailCallback);
        mRvInProgress.setAdapter(inProgressAdapter);

        mFab = (CustomFloatingActionButton) getActivity().findViewById(R.id.activity_home_fab);
        mRvInProgress.addOnScrollListener(onScrollListener);

        return view;
    }

    public void setFabController(HomeActivity.fabController mFabController) {
        this.mFabController = mFabController;
    }

    public void setLaunchDetailCallback(View.OnClickListener callback) {
        this.mLaunchDetailCallback = callback;
    }

    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (dy > 0 && mFab.mVisible) mFabController.hide();

            if (dy < 0 && !mFab.mVisible) mFabController.show();
        }
    };
}
