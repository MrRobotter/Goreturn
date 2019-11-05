package com.joinyon.houge.mvp.model;

import com.joinyon.houge.api.Api;
import com.joinyon.houge.bean.LoginBean;

import com.joinyon.houge.mvp.contract.LoginContract;
import com.xusangbo.basemoudle.baserx.RxSchedulers;

import io.reactivex.Flowable;

public class LoginModel implements LoginContract.Model {
@Override
public Flowable<LoginBean> login(String loginName, String password) {
        return Api.getDefault().login(loginName, password).compose(RxSchedulers.<LoginBean>io_main()); }
}
