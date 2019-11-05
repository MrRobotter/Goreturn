package com.joinyon.houge.mvp.contract;

import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.base.RegisterBean;
import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface RegisterContract {
    interface Model extends BaseModel {
        /**
         * 注册
         *
         * @return
         */
        Flowable<RegisterBean> register(String SJHM, String SJYZM,String MM);

        /**
         * 验证码
         *
         * @param requestBody
         * @return
         */
        Flowable<BaseBean> send_verify_code(RequestBody requestBody);


    }

    interface View extends BaseView {

        void onRegister(RegisterBean bean);

        void onSendVerifyCode(BaseBean bean);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {

        public abstract void register(String SJHM, String SJYZM,String MM);

        public abstract void send_verify_code(RequestBody requestBody);

    }
}
