package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class InProgressFragment extends Fragment {
    private RecyclerView rvInProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_in_progress,container,false);

        rvInProgress=(RecyclerView)view.findViewById(R.id.rv_in_progress);
        rvInProgress.setHasFixedSize(true);
        rvInProgress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        InProgressAdapter inProgressAdapter=new InProgressAdapter();
        rvInProgress.setAdapter(inProgressAdapter);
        return view;
    }
}
