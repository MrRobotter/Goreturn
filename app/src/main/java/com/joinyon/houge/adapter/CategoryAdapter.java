package com.joinyon.houge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joinyon.houge.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private List<String> dataList;
    private LayoutInflater layoutInflater;
    private int position=0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public CategoryAdapter(Context context, List<String> dataList) {
        this.dataList = dataList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.relativeLayout = view.findViewById(R.id.rlItem);
            holder.text = (TextView) view.findViewById(R.id.tvMap);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String s = dataList.get(i);
        holder.text.setText(s);
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        if (i == position) {
            holder.relativeLayout.setSelected(true);
        } else {
            holder.relativeLayout.setSelected(false);
        }
        return view;
    }


    class ViewHolder {
        RelativeLayout relativeLayout;
        TextView text;
    }
}
