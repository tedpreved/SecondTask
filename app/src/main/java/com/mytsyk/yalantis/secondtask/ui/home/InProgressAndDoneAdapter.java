package com.mytsyk.yalantis.secondtask.ui.home;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.model.ItemTestData;

import java.util.ArrayList;

public class InProgressAndDoneAdapter extends RecyclerView.Adapter<InProgressAndDoneAdapter.ViewHolder> {

    private OnLaunchDetailsListener onLaunchDetailsListener;
    private ArrayList<ItemTestData> mDataInProgress;

    public InProgressAndDoneAdapter(ArrayList<ItemTestData> data, OnLaunchDetailsListener listener) {
        mDataInProgress = data;
        onLaunchDetailsListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_progress, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ItemTestData currentItem = mDataInProgress.get(position);

        holder.mTvName.setText(currentItem.getTitle());
        holder.mTvAddress.setText(currentItem.getAddress());
        holder.mTvDate.setText(currentItem.getDate());

        if (currentItem.getDaysCount() != null) {
            holder.mTvCountDay.setVisibility(View.VISIBLE);
            holder.mTvCountDay.setText(currentItem.getDaysCount());
        }
        if (onLaunchDetailsListener != null) {
            holder.mCardView.setOnClickListener(onCardClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return mDataInProgress == null ? 0 : mDataInProgress.size();
    }


    private View.OnClickListener onCardClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onLaunchDetailsListener.onDetailClick(view);
        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mCardView;
        private TextView mTvName;
        private TextView mTvAddress;
        private TextView mTvDate;
        private TextView mTvCountDay;

        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.item_in_progress_cardview);
            mTvName = (TextView) itemView.findViewById(R.id.item_in_progress_tv_name);
            mTvAddress = (TextView) itemView.findViewById(R.id.item_in_progress_tv_address);
            mTvDate = (TextView) itemView.findViewById(R.id.item_in_progress_tv_date);
            mTvCountDay = (TextView) itemView.findViewById(R.id.item_in_progress_tv_count_day);
        }
    }
}
