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
    private RecyclerView rvInProgress;
    private CustomFloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_in_progress,container,false);

        rvInProgress=(RecyclerView)view.findViewById(R.id.rv_in_progress);
        rvInProgress.setHasFixedSize(true);
        rvInProgress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        InProgressAdapter inProgressAdapter=new InProgressAdapter();
        rvInProgress.setAdapter(inProgressAdapter);

        fab=(CustomFloatingActionButton)getActivity().findViewById(R.id.activity_home_fab);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        rvInProgress.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0 ||dy<0){
                    if(fab.isShown()){
                        fab.hide();
                    }else {
                        fab.show();
                    }

                }
            }
            /*
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                   if(fab.getVisibility()==View.INVISIBLE){
                       fab.show();
                   }
                }

                super.onScrollStateChanged(recyclerView, newState);
            }*/
        });
    }
}
