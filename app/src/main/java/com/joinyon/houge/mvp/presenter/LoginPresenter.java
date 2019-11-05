package com.joinyon.houge.mvp.presenter;

import com.joinyon.houge.bean.LoginBean;
import com.joinyon.houge.mvp.contract.LoginContract;
import com.xusangbo.basemoudle.baserx.RxSubscriber;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class LoginPresenter extends LoginContract.Presenter {
    @Override
    public void login(String loginName, String password) {
        mModel.login(loginName, password).subscribe(new RxSubscriber<LoginBean>(mContext, true, "正在登录") {
            @Override
            protected void _onNext(LoginBean bean) {
                //处理请求返回数据
                mView.onLogin(bean);
            }

            @Override
            protected void _onError(String message) {
                ToastUtils.showShortToast(mContext, message);
            }
        });
    }
}
