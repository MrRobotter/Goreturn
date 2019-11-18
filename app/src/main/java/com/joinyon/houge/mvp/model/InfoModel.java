package com.joinyon.houge.mvp.model;

import com.joinyon.houge.api.Api;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.mvp.contract.InfoContract;
import com.xusangbo.basemoudle.baserx.RxSchedulers;

import io.reactivex.Flowable;

public class InfoModel implements InfoContract.Model {
    @Override
    public Flowable<BaseBean> changeInformation(String APPUSER_ID, String ZCBZ, String XM, String XB, String SZCS, String DZYX, String GZDW, String DWJC, String GZDD, String SSBM, String GZZW, String DWLB) {
        return Api.getDefault().changeInformation(APPUSER_ID, ZCBZ, XM, XB, SZCS, DZYX, GZDW, DWJC, GZDD, SSBM, GZZW, DWLB).compose(RxSchedulers.<BaseBean>io_main());
    }

    @Override
    public Flowable<DicListBean> getDicList(String BIANMA) {
        return Api.getDefault().getDicList(BIANMA).compose(RxSchedulers.<DicListBean>io_main());
    }

    @Override
    public Flowable<BaseBean> changeBusiness(String APPUSER_ID, String ZCBZ, String YWJS, String YWLX, String GZLY, String YWJD, String YWQY, String DWJC) {
        return Api.getDefault().changeBusiness(APPUSER_ID, ZCBZ, YWJS, YWLX, GZLY, YWJD, YWQY, DWJC).compose(RxSchedulers.<BaseBean>io_main());
    }
}

