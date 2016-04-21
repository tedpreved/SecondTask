package com.mytsyk.yalantis.secondtask;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InProgressAdapter extends RecyclerView.Adapter<InProgressAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_progress, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIcCardViewBig;
        private TextView mTvCountLike;
        private TextView mTvName;
        private TextView mTvAddress;
        private TextView mTvDate;
        private TextView mTvCountDay;

        public ViewHolder(View itemView) {
            super(itemView);
            mIcCardViewBig = (ImageView) itemView.findViewById(R.id.item_in_progress_ic_big);
            mTvCountLike = (TextView) itemView.findViewById(R.id.item_in_progress_tv_like);
            mTvName = (TextView) itemView.findViewById(R.id.item_in_progress_tv_name);
            mTvAddress = (TextView) itemView.findViewById(R.id.item_in_progress_tv_address);
            mTvDate = (TextView) itemView.findViewById(R.id.item_in_progress_tv_date);
            mTvCountDay = (TextView) itemView.findViewById(R.id.item_in_progress_tv_count_day);
        }
    }
}
