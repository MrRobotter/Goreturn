package com.joinyon.houge.mvp.presenter;

import com.joinyon.houge.R;
import com.joinyon.houge.bean.AdverListBean;
import com.joinyon.houge.bean.BusinessListBean;
import com.joinyon.houge.mvp.contract.BusinessContract;
import com.xusangbo.basemoudle.baserx.RxSubscriber;
import com.xusangbo.basemoudle.utils.ToastUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class BuinessPresenter extends BusinessContract.Presenter {
    @Override
    public void getCuserList(String YHLX, String keywords, String PXLX, String GZLY, String YWQY, String YWLX, String YWJD, String SFTJ, String currentPage) {
        mModel.getCuserList(YHLX, keywords, PXLX, GZLY, YWQY, YWLX, YWJD, SFTJ, currentPage).subscribe(new RxSubscriber<BusinessListBean>(mContext, true, "加载中……") {
            @Override
            protected void _onNext(BusinessListBean businessListBean) {
                mView.onGetCuserList(businessListBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }

    @Override
    public void getCuserList() {
        mModel.getCuserList().subscribe(new RxSubscriber<BusinessListBean>(mContext, true, "加载中……") {

            @Override
            protected void _onNext(BusinessListBean businessListBean) {
                mView.onGetCuserList(businessListBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }


        });
    }

    @Override
    public void getAdvertisingLis(String SHOW_TYPE) {
        mModel.getAdvertisingLis(SHOW_TYPE).subscribe(new RxSubscriber<AdverListBean>(mContext, false) {
            @Override
            protected void _onNext(AdverListBean adverListBean) {
                mView.onGetAdvertisingLis(adverListBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }
}
