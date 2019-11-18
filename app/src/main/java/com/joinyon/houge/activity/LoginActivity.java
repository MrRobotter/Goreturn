package com.joinyon.houge.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.joinyon.houge.bean.LoginBean;
import com.joinyon.houge.mvp.contract.LoginContract;
import com.joinyon.houge.mvp.model.LoginModel;
import com.joinyon.houge.mvp.presenter.LoginPresenter;
import com.joinyon.houge.utils.SPHelper;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {
    private Button btnLogin;
    private TextView tvRegister;
    private EditText etPhone;
    private EditText etPwd;
    private TextView tvForgot;

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        initStatusBar();
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /**
     * 登录
     */
    private void doLogin() {
        String phone = etPhone.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShortToast(mContext, "请输入手机号码!");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showShortToast(mContext, "请输入密码!");
            return;
        }
        mPresenter.login(phone, pwd);

    }

    private void doForgot() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 注册
     */
    private void doRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void initView() {
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        etPhone = findViewById(R.id.etPhone);
        etPwd = findViewById(R.id.etPwd);
        tvForgot = findViewById(R.id.tvForgot);
        tvForgot.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onLogin(LoginBean bean) {
        if (bean != null) {
            if (bean.getResultCode().equals("2")) {
                ToastUtils.showShortToast(mContext, "手机号码或密码错误");
            } else if (bean.getResultCode().equals("1")) {
                //ToastUtils.showShortToast(mContext, "成功!");
                SPHelper.setUid(bean.getAPPUSER_ID());
                String zcbz = bean.getZCBZ();
                SPHelper.setZCbz(zcbz);

                if (zcbz.equals("1")) {//1-填写基本信息
                    Intent intent = new Intent(this, BaseInfoActivity.class);
                    startActivity(intent);
                    finish();
                } else if (zcbz.equals("2")) {//2-填写业务信息
                    Intent intent = new Intent(this, BusinessInfoActivity.class);
                    startActivity(intent);
                    finish();

                } else if (zcbz.equals("3") || zcbz.equals("4") || zcbz.equals("5")) {//3-上传名片
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            } else if (bean.getResultCode().equals("4")) {
                ToastUtils.showShortToast(mContext, "处理过程异常!");
            }
        } else {
            ToastUtils.showShortToast(mContext, "数据解析错误!");
        }

    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                doLogin();
                break;

            case R.id.tvRegister:
                doRegister();
                break;

            case R.id.tvForgot:
                doForgot();
                break;

            default:
                break;


        }
    }
}
