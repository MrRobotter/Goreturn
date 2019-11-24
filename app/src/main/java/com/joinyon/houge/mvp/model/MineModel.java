package com.joinyon.houge.mvp.model;

import com.joinyon.houge.api.Api;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.mvp.contract.MineContract;
import com.xusangbo.basemoudle.baserx.RxSchedulers;

import io.reactivex.Flowable;

public class MineModel implements MineContract.Model {

    @Override
    public Flowable<BaseBean> userTpUpload(String TP, String TPLX, String APPUSER_ID, String ZCBZ) {
        return Api.getDefault().userTpUpload(TP, TPLX, APPUSER_ID, ZCBZ).compose(RxSchedulers.<BaseBean>io_main());
    }
}
