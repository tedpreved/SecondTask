package com.mytsyk.yalantis.secondtask;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NotDoneListViewAdapter extends BaseAdapter{
    private Context mContext;

    public NotDoneListViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 10;
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
            holder.mCardView=(CardView)view.findViewById(R.id.item_in_progress_cardview);
            //
            view.setTag(holder);
        } else {
            holder = (HolderNotDone) view.getTag();
        }
        //Log.v("cardviewheight")

        return view;
    }

    private class HolderNotDone{
        private CardView mCardView;
        private ImageView mIcCardViewBig;
        private TextView mTvCountLike;
        private TextView mTvName;
        private TextView mTvAddress;
        private TextView mTvDate;
    }
}
