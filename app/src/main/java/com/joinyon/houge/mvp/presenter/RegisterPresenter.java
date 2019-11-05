package com.joinyon.houge.mvp.presenter;

import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.joinyon.houge.mvp.contract.RegisterContract;
import com.xusangbo.basemoudle.baserx.RxSubscriber;
import com.xusangbo.basemoudle.utils.ToastUtils;

import okhttp3.RequestBody;

public class RegisterPresenter extends RegisterContract.Presenter {


    @Override
    public void register(String SJHM, String SJYZM, String MM) {
        mModel.register(SJHM, SJYZM, MM).subscribe(new RxSubscriber<RegisterBean>(mContext, true) {
            @Override
            protected void _onNext(RegisterBean bean) {
                //处理请求返回数据
                mView.onRegister(bean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }

    @Override
    public void send_verify_code(RequestBody requestBody) {

    }
}
