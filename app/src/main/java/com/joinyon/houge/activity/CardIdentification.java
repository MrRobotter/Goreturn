package com.joinyon.houge.activity;

import android.os.Bundle;
import android.view.View;

import com.joinyon.houge.R;
import com.xusangbo.basemoudle.base.BaseActivity;

public class CardIdentification extends BaseActivity {
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_card_identification;
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
