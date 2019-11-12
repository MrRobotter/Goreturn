package com.joinyon.houge.activity;

import android.os.Bundle;
import android.util.Log;

import com.joinyon.houge.R;
import com.joinyon.houge.utils.StatusBarUtil;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanActivity extends BaseActivity implements QRCodeView.Delegate {
    private ZXingView scanView;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_scan;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        StatusBarUtil.transparencyBar(this);
        scanView = findViewById(R.id.scanView);
        scanView.setDelegate(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        scanView.startCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanView.startSpot();
    }

    @Override
    protected void onStop() {
        scanView.startCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        scanView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.e("TAG", result);
        ToastUtils.showLongToast(this, result);
        finish();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
    }
}
