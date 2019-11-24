package com.joinyon.houge.mvp.model;

import com.joinyon.houge.api.Api;
import com.joinyon.houge.bean.AdverListBean;
import com.joinyon.houge.bean.BusinessListBean;
import com.joinyon.houge.mvp.contract.BusinessContract;
import com.xusangbo.basemoudle.baserx.RxSchedulers;

import io.reactivex.Flowable;

public class BuinessModel implements BusinessContract.Model {
    @Override
    public Flowable<BusinessListBean> getCuserList(String YHLX, String keywords, String PXLX, String GZLY, String YWQY, String YWLX, String YWJD, String SFTJ, String currentPage) {
        return Api.getDefault().getCuserList(YHLX, keywords, PXLX, GZLY, YWQY, YWLX, YWJD, SFTJ, currentPage).compose(RxSchedulers.<BusinessListBean>io_main());
    }

    @Override
    public Flowable<BusinessListBean> getCuserList() {
        return Api.getDefault().getCuserList().compose(RxSchedulers.<BusinessListBean>io_main());
    }

    @Override
    public Flowable<AdverListBean> getAdvertisingLis(String SHOW_TYPE) {
        return Api.getDefault().getAdvertisingLis(SHOW_TYPE).compose(RxSchedulers.<AdverListBean>io_main());
    }

}
