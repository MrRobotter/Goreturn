package com.joinyon.houge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.joinyon.houge.R;
import com.xusangbo.basemoudle.base.BaseActivity;

/**
 * 照片认证
 */
public class FaceIdentification extends BaseActivity {
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_face_identification;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {

    }

    public void skip(View view) {
        Intent intent = new Intent(this, IDCardIdentification.class);
        startActivity(intent);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void submit(View view) {
    }
}
