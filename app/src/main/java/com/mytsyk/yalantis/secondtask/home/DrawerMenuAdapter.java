package com.mytsyk.yalantis.secondtask.home;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mytsyk.yalantis.secondtask.R;


public class DrawerMenuAdapter extends BaseAdapter {
    private Context mContext;
    private int[] mIconIds;
    private String[] mStringId;


    public DrawerMenuAdapter(Context context, int[] iconMass, String[] menuTextMass){
        this.mContext=context;
        this.mIconIds=iconMass;
        this.mStringId=menuTextMass;
    }
    @Override
    public int getCount() {
        return mIconIds==null ? 0 : mIconIds.length;
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
        final HolderMenu holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_menu_drawer, parent, false);
            holder = new HolderMenu();
            holder.mMenuIcon=(ImageView) view.findViewById(R.id.item_menu_drawer_im_icon);
            holder.mMenuTitle=(TextView) view.findViewById(R.id.item_menu_drawer_title);
            view.setTag(holder);
        } else {
            holder = (HolderMenu) view.getTag();
        }
            holder.mMenuTitle.setText(mStringId[position]);
            holder.mMenuIcon.setImageDrawable(ContextCompat.getDrawable(mContext,mIconIds[position]));

        return view;
    }

    private class HolderMenu{
        private ImageView mMenuIcon;
        private TextView mMenuTitle;
    }
}
