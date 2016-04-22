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
    private CustomFloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_not_done,container,false);

        lvNotDone=(ListView)view.findViewById(R.id.fragment_not_done_lv_not_done);
        NotDoneListViewAdapter notDoneListViewAdapter=new NotDoneListViewAdapter(getActivity());
        lvNotDone.setAdapter(notDoneListViewAdapter);
        return view;
    }

    public void setFabButton(CustomFloatingActionButton fabButton){
        this.floatingActionButton = fabButton;
    }

    @Override
    public void onResume() {
        super.onResume();
        floatingActionButton.attachToListView(lvNotDone, scrollDirectionListener, onScrollListener);
    }

    private ScrollDirectionListener scrollDirectionListener = new ScrollDirectionListener() {
        @Override
        public void onScrollDown() {

        }

        @Override
        public void onScrollUp() {

        }
    };

    private  AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    };
}
