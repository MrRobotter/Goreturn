package com.joinyon.houge.mvp.presenter;

import android.util.Log;

import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.mvp.contract.InfoContract;
import com.xusangbo.basemoudle.baserx.RxSubscriber;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class InfoPresenter extends InfoContract.Presenter {
    @Override
    public void changeInformation(String APPUSER_ID, String ZCBZ, String XM, String XB, String SZCS, String DZYX, String GZDW, String DWJC, String GZDD, String SSBM, String GZZW, String DWLB) {
        mModel.changeInformation(APPUSER_ID, ZCBZ, XM, XB, SZCS, DZYX, GZDW, DWJC, GZDD, SSBM, GZZW, DWLB).subscribe(new RxSubscriber<BaseBean>(mContext, true, "资料提交中……") {
            @Override
            protected void _onNext(BaseBean baseBean) {
                Log.e("changeInformation", baseBean.toString());
                mView.onChangeInformation(baseBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }

    @Override
    public void getDicList(String BIANMA) {
        mModel.getDicList(BIANMA).subscribe(new RxSubscriber<DicListBean>(mContext, false) {
            @Override
            protected void _onNext(DicListBean dicListBean) {
                mView.onGetDicList(dicListBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }

    @Override
    public void changeBusiness(String APPUSER_ID, String ZCBZ, String YWJS, String YWLX, String GZLY, String YWJD, String YWQY, String DWJC) {
        mModel.changeBusiness(APPUSER_ID, ZCBZ, YWJS, YWLX, GZLY, YWJD, YWQY, DWJC).subscribe(new RxSubscriber<BaseBean>(mContext, true, "资料提交中……") {
            @Override
            protected void _onNext(BaseBean baseBean) {
                mView.onChangeBusiness(baseBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);

            }
        });
    }
}
