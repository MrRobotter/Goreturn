package com.joinyon.houge.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


import com.joinyon.houge.R;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.joinyon.houge.mvp.contract.RegisterContract;
import com.joinyon.houge.mvp.model.RegisterModel;
import com.joinyon.houge.mvp.presenter.RegisterPresenter;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterModel> implements RegisterContract.View {
    private EditText edit_user;
    private EditText edit_verify;
    private EditText edit_pwd1;
    private EditText edit_pwd;
    private Button btn_send;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }


    private void initColor() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            window.setStatusBarColor(getResources().getColor(R.color.white));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }


    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        initColor();
        edit_user = findViewById(R.id.edit_user);
        edit_verify = findViewById(R.id.edit_verify);
        btn_send = findViewById(R.id.btn_send);
        edit_pwd1 = findViewById(R.id.edit_pwd1);
        edit_pwd = findViewById(R.id.edit_pwd);
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

    public void back(View view) {
        onBackPressed();
    }

    public void sendSmscode(View view) {
        String username = edit_user.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtils.showShortToast(this, "请输入手机号");
            return;
        }
    }

    public void register(View view) {
        String username = edit_user.getText().toString().trim();
        String verify = edit_verify.getText().toString().trim();
        String pwd1 = edit_pwd1.getText().toString().trim();
        String pwd = edit_pwd.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            ToastUtils.showShortToast(this, "请输入手机号");
            return;
        }

        if (TextUtils.isEmpty(verify)) {
            ToastUtils.showShortToast(this, "请输入验证码");
            return;
        }

        if (TextUtils.isEmpty(pwd1)) {
            ToastUtils.showShortToast(this, "请输入密码");
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showShortToast(this, "请确认密码");
            return;
        }

        if (!pwd.equals(pwd1)) {
            ToastUtils.showShortToast(this, "两次密码输入不一致");
            return;
        }
        mPresenter.register(username, verify, pwd);
    }

    @Override
    public void onRegister(RegisterBean bean) {
        // Log.e("RegisterActivity", bean.toString());
        if (bean != null) {
            if (bean.getResultCode().equals("3")) {
                ToastUtils.showShortToast(mContext, "该手机号码已被注册");
            } else if (bean.getResultCode().equals("1")) {
                ToastUtils.showShortToast(mContext, "注册成功!");
                finish();
            } else if (bean.getResultCode().equals("4")) {
                ToastUtils.showShortToast(mContext, "注册失败!");
            } else if (bean.getResultCode().equals("5")) {
                ToastUtils.showShortToast(mContext, "该手机号码已被禁止使用!");
            }
        } else {
            ToastUtils.showShortToast(mContext, "数据解析错误!");
        }


    }

    @Override
    public void onSendVerifyCode(BaseBean bean) {

    }
}
