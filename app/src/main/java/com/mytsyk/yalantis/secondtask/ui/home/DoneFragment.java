package com.mytsyk.yalantis.secondtask.ui.home;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;


public class DoneFragment extends Fragment {
    private RecyclerView mRvInProgress;
    private FabChangeVisibilityListener mFabChangeVisibilityListener;

    private OnLaunchDetailsListener mLaunchDetailListener;
    private List<ItemTestData> mDataInProgress;

    public static DoneFragment newInstance() {
        DoneFragment doneFragment = new DoneFragment();
        return doneFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mLaunchDetailListener = (OnLaunchDetailsListener) context;
            mFabChangeVisibilityListener = (FabChangeVisibilityListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement OnLaunchDetailListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_in_progress, container, false);
        initData();
        mRvInProgress = (RecyclerView) view.findViewById(R.id.rv_in_progress);
        mRvInProgress.setHasFixedSize(true);
        mRvInProgress.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        InProgressAndDoneAdapter inProgressAndDoneAdapter =
                new InProgressAndDoneAdapter((ArrayList<ItemTestData>) mDataInProgress, mLaunchDetailListener);
        mRvInProgress.setAdapter(inProgressAndDoneAdapter);

        mRvInProgress.addOnScrollListener(onScrollListener);

        return view;
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

    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (mFabChangeVisibilityListener == null) return;
            if (dy > 0) mFabChangeVisibilityListener.hideFab();

            if (dy < 0) mFabChangeVisibilityListener.showFab();
        }
    };
}
