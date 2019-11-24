package com.joinyon.houge.mvp.contract;

import com.joinyon.houge.base.BaseBean;
import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;

import io.reactivex.Flowable;

/**
 * 图片上传
 */
public interface UserTpUploadContract {
    interface Model extends BaseModel {
        Flowable<BaseBean> userTpUpload(
                String TP,
                String TPLX,
                String APPUSER_ID,
                String ZCBZ // 注册步骤 1-填写基本信息  2-填写业务信息 3-上传名片 4-上传身份证 5-朋友认证，6，已完成  当刚注册好进来时加业务信息是，传值4，5，6
        );

    }

    interface View extends BaseView {
        void onUserTpUpload(BaseBean bean);
    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void userTpUpload(
                String TP,
                String TPLX,
                String APPUSER_ID,
                String ZCBZ // 注册步骤 1-填写基本信息  2-填写业务信息 3-上传名片 4-上传身份证 5-朋友认证，6，已完成  当刚注册好进来时加业务信息是，传值4，5，6
        );
    }
}
