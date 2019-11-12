package com.joinyon.houge.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.joinyon.houge.activity.MyQRcodeActivity;
import com.joinyon.houge.activity.ScanActivity;
import com.joinyon.houge.adapter.CategoryAdapter;
import com.joinyon.houge.adapter.MineToolsAdapter;
import com.joinyon.houge.bean.MineToolsBean;
import com.xusangbo.basemoudle.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    private MainActivity activity;
    private GridView gridView;
    private List<MineToolsBean> dataList = new ArrayList<>();
    private MineToolsAdapter adapter;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        gridView = activity.findViewById(R.id.gridView);
        dataList.add(new MineToolsBean(R.mipmap.icon_foot_mine, "我的收藏"));
        dataList.add(new MineToolsBean(R.mipmap.icon_menber, "我的关注"));
        dataList.add(new MineToolsBean(R.mipmap.icon_collection_mine, "谁看过我"));
        dataList.add(new MineToolsBean(R.mipmap.icon_sub_sale, "谁关注我"));

        dataList.add(new MineToolsBean(R.mipmap.icon_realse, "我的发布"));
        dataList.add(new MineToolsBean(R.mipmap.icon_push_mine, "我的推送"));
        dataList.add(new MineToolsBean(R.mipmap.icon_custmer_mine, "我的收件"));
        dataList.add(new MineToolsBean(R.mipmap.icon_help, "业务定位"));

        dataList.add(new MineToolsBean(R.mipmap.icon_message_mine, "使用手册"));
        dataList.add(new MineToolsBean(R.mipmap.icon_cont_mine, "遇见客服"));
        dataList.add(new MineToolsBean(R.mipmap.icon_confirm, "追加认证"));
        dataList.add(new MineToolsBean(R.mipmap.icon_gift_mine, "邀请有礼"));

        adapter = new MineToolsAdapter(activity, dataList);
        gridView.setAdapter(adapter);
        activity.findViewById(R.id.rlScancode).setOnClickListener(this);
        activity.findViewById(R.id.rlQrCode).setOnClickListener(this);
        activity.findViewById(R.id.rlSettings).setOnClickListener(this);
        activity.findViewById(R.id.rlMessage).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.rlScancode:
                intent = new Intent(activity, ScanActivity.class);
                startActivity(intent);
                break;

            case R.id.rlQrCode:
                intent = new Intent(activity, MyQRcodeActivity.class);
                startActivity(intent);
                break;

            case R.id.rlSettings:

                break;

            case R.id.rlMessage:

                break;

            default:
                break;
        }

    }
}
