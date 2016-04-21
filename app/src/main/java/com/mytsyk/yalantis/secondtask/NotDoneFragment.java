package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class NotDoneFragment extends Fragment {
    private ListView lvNotDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_not_done,container,false);

        lvNotDone=(ListView)view.findViewById(R.id.fragment_not_done_lv_not_done);
        NotDoneListViewAdapter notDoneListViewAdapter=new NotDoneListViewAdapter(getActivity());
        lvNotDone.setAdapter(notDoneListViewAdapter);
        return view;
    }
}
