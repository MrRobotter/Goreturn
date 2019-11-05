package com.joinyon.houge.mvp.contract;

import com.joinyon.houge.bean.LoginBean;
import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;

import io.reactivex.Flowable;

public interface LoginContract {

    interface Model extends BaseModel {
        Flowable<LoginBean> login(String loginName, String password);
    }

    interface View extends BaseView {
        void onLogin(LoginBean bean);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void login(String loginName, String password);

    }
}
