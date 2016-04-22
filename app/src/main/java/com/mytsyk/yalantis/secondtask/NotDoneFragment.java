package com.mytsyk.yalantis.secondtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.mytsyk.yalantis.secondtask.fab.CustomFloatingActionButton;
import com.mytsyk.yalantis.secondtask.fab.ScrollDirectionListener;


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

    @Override
    public void onResume() {
        super.onResume();
        CustomFloatingActionButton fab=(CustomFloatingActionButton) ((HomeActivity) getActivity()).getFab();
        fab.attachToListView(lvNotDone, new ScrollDirectionListener() {
            @Override
            public void onScrollDown() {
                //Log.d("ListViewFragment", "onScrollDown()");
            }

            @Override
            public void onScrollUp() {
                //Log.d("ListViewFragment", "onScrollUp()");
            }
        }, new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                //Log.d("ListViewFragment", "onScrollStateChanged()");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                    Log.d("ListViewFragment", "onScroll()");
            }
        });
    }
}
