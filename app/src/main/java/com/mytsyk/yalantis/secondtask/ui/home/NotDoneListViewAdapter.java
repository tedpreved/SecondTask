package com.mytsyk.yalantis.secondtask.ui.home;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytsyk.yalantis.secondtask.R;
import com.mytsyk.yalantis.secondtask.model.ItemTestData;

import java.util.ArrayList;

public class NotDoneListViewAdapter extends BaseAdapter {
    private Context mContext;
    private View.OnClickListener mLaunchDetailCallback;
    private ArrayList<ItemTestData> mDataInProgress;

    public NotDoneListViewAdapter(Context mContext, ArrayList<ItemTestData> data,
                                  View.OnClickListener callback) {
        this.mContext = mContext;
        this.mDataInProgress = data;
        this.mLaunchDetailCallback = callback;
    }

    @Override
    public int getCount() {
        return mDataInProgress == null ? 0 : mDataInProgress.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final HolderNotDone holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_not_done, parent, false);
            holder = new HolderNotDone();
            holder.mCardView = (CardView) view.findViewById(R.id.item_in_progress_cardview);
            holder.mImIconBig = (ImageView) view.findViewById(R.id.item_in_progress_ic_big);
            holder.mTvCountLike = (TextView) view.findViewById(R.id.item_in_progress_tv_like);
            holder.mTvName = (TextView) view.findViewById(R.id.item_in_progress_tv_name);
            holder.mTvAddress = (TextView) view.findViewById(R.id.item_in_progress_tv_address);
            holder.mTvDate = (TextView) view.findViewById(R.id.item_in_progress_tv_date);

            view.setTag(holder);
        } else {
            holder = (HolderNotDone) view.getTag();
        }
        final ItemTestData currentItem = mDataInProgress.get(position);

        holder.mTvName.setText(currentItem.getTitle());
        holder.mTvAddress.setText(currentItem.getAddress());
        holder.mTvDate.setText(currentItem.getDate());

        if (mLaunchDetailCallback != null) {
            holder.mCardView.setOnClickListener(mLaunchDetailCallback);
        }
        return view;
    }

    private class HolderNotDone {
        private CardView mCardView;
        private ImageView mImIconBig;
        private TextView mTvCountLike;
        private TextView mTvName;
        private TextView mTvAddress;
        private TextView mTvDate;
    }
}
