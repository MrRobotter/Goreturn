package com.joinyon.houge.mvp.model;

import com.joinyon.houge.api.Api;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.joinyon.houge.mvp.contract.RegisterContract;
import com.xusangbo.basemoudle.baserx.RxSchedulers;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class RegisterModel implements RegisterContract.Model {


    @Override
    public Flowable<RegisterBean> register(String SJHM, String SJYZM, String MM) {
        return Api.getDefault().register(SJHM, SJYZM, MM).compose(RxSchedulers.<RegisterBean>io_main());
    }

    @Override
    public Flowable<BaseBean> send_verify_code(RequestBody requestBody) {
        return null;
    }
}
