package com.joinyon.houge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.bean.DicListBean;
import com.xusangbo.basemoudle.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class BusinCateAdapter extends BaseAdapter {
    private List<DicListBean.ResultListBean> dataList;
    private LayoutInflater layoutInflater;
    private Context context;
    private List<Integer> integerList = new ArrayList<>();

    private int position = 0;

    public void reset() {
        integerList = new ArrayList<>();
        for (DicListBean.ResultListBean bean : dataList) {
            bean.setS(false);
        }
        notifyDataSetChanged();
    }

    public String getStrings() {
        String content = " ";
        for (DicListBean.ResultListBean bean : dataList) {
            if (bean.isS()) {
                content = content + bean.getKey() + ";";
            }
        }
        return content.substring(0, content.length() - 1);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public BusinCateAdapter(Context context, List<DicListBean.ResultListBean> dataList) {
        this.dataList = dataList;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
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

        DicListBean.ResultListBean s = dataList.get(i);
        holder.text.setText(s.getValue());
        if (s.isS()) {
            holder.relativeLayout.setSelected(true);
        } else {
            holder.relativeLayout.setSelected(false);
        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (integerList.size() < 3) {
                    integerList.add(i);
                    dataList.get(i).setS(true);
                } else {
                    ToastUtils.showShortToast(context, "最多只能选择三项");
                }

                notifyDataSetChanged();
            }
        });

//        for (int j : integerList) {
//            if (j == position) {
//                holder.relativeLayout.setSelected(true);
//            } else {
//                holder.relativeLayout.setSelected(false);
//            }
//        }
        return view;
    }

    class ViewHolder {
        RelativeLayout relativeLayout;
        TextView text;
    }
}
