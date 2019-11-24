package com.joinyon.houge.mvp.presenter;

import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.mvp.contract.MineContract;
import com.xusangbo.basemoudle.baserx.RxSubscriber;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class MinePresenter extends MineContract.Presenter {
    @Override
    public void userTpUpload(String TP, String TPLX, String APPUSER_ID, String ZCBZ) {
        mModel.userTpUpload(TP, TPLX, APPUSER_ID, ZCBZ).subscribe(new RxSubscriber<BaseBean>(mContext, true, "上传中……") {
            @Override
            protected void _onNext(BaseBean baseBean) {
                mView.onUserTpUpload(baseBean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }
}
