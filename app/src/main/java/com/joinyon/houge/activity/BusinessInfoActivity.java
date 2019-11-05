package com.joinyon.houge.activity;

import android.os.Bundle;
import android.view.View;

import com.joinyon.houge.R;
import com.xusangbo.basemoudle.base.BaseActivity;

public class BusinessInfoActivity extends BaseActivity {
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_business_info;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    public void skip(View view) {
    }

    public void back(View view) {
        onBackPressed();
    }

    public void submit(View view) {
    }
}
