package com.joinyon.houge.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.widget.FlowLayout;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private FlowLayout flowLayout;
    private List<String> list = new ArrayList<>();

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        flowLayout = findViewById(R.id.flow);
        list.add("房地产基金");
        list.add("大数据");
        list.add("大健康");
        list.add("影视投资");
        list.add("杭州金投");
        list.add("过桥资金");


//往容器内添加TextView数据
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 10, 15, 10);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(30, 30, 30, 30);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setTextSize(13);
            tv.setSingleLine();
            tv.setTextColor(getResources().getColor(R.color.textHot));
            tv.setBackgroundResource(R.drawable.search_hot_bg);
            tv.setLayoutParams(layoutParams);
            flowLayout.addView(tv, layoutParams);
            tv.setOnClickListener(this);
        }

    }

    public void cancel(View view) {
        onBackPressed();
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof TextView) {
            TextView tv = (TextView) view;
            String s = tv.getText().toString();
            ToastUtils.showLongToast(this, s);
        }
    }
}
