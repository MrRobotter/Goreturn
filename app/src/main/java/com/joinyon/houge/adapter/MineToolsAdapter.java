package com.joinyon.houge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.bean.MineToolsBean;

import java.util.List;

public class MineToolsAdapter extends BaseAdapter {
    private List<MineToolsBean> dataList;
    private LayoutInflater layoutInflater;

    public MineToolsAdapter(Context context, List<MineToolsBean> dataList) {
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
            view = layoutInflater.inflate(R.layout.mine_tools_item, null);
            holder = new ViewHolder();
            holder.layout = view.findViewById(R.id.rlItem);
            holder.text = (TextView) view.findViewById(R.id.tvMap);
            holder.imageView = view.findViewById(R.id.tvImage);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        MineToolsBean s = dataList.get(i);
        holder.text.setText(s.getTool());
        holder.imageView.setImageResource(s.getImageId());

        return view;
    }


    class ViewHolder {
        LinearLayout layout;
        TextView text;
        ImageView imageView;
    }
}
