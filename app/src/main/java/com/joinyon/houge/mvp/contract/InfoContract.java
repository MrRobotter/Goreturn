package com.joinyon.houge.mvp.contract;

import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.bean.LoginBean;
import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;

import io.reactivex.Flowable;
import retrofit2.http.Field;

public interface InfoContract {
    interface Model extends BaseModel {
        Flowable<BaseBean> changeInformation(
                String APPUSER_ID,
                String ZCBZ,
                String XM,
                String XB,
                String SZCS,
                String DZYX,
                String GZDW,
                String DWJC,
                String GZDD,
                String SSBM,
                String GZZW,
                String DWLB
        );

        Flowable<DicListBean> getDicList(String BIANMA);

        Flowable<BaseBean> changeBusiness(String APPUSER_ID,//用户ID
                                          String ZCBZ,//注册步骤 3
                                          String YWJS,//业务角色
                                          String YWLX,//角色类型
                                          String GZLY,//关注领域	多个以“；”分割
                                          String YWJD,//业务阶段	多个以“；”分割
                                          String YWQY,//	业务区域
                                          String DWJC//业务案例
        );


    }

    interface View extends BaseView {
        void onChangeInformation(BaseBean bean);

        void onGetDicList(DicListBean dicListBean);

        void onChangeBusiness(BaseBean baseBean);

    }

    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void changeInformation(
                String APPUSER_ID,
                String ZCBZ,
                String XM,
                String XB,
                String SZCS,
                String DZYX,
                String GZDW,
                String DWJC,
                String GZDD,
                String SSBM,
                String GZZW,
                String DWLB
        );

        public abstract void getDicList(String BIANMA);

        public abstract void changeBusiness(String APPUSER_ID,//用户ID
                                            String ZCBZ,//注册步骤 3
                                            String YWJS,//业务角色
                                            String YWLX,//角色类型
                                            String GZLY,//关注领域	多个以“；”分割
                                            String YWJD,//业务阶段	多个以“；”分割
                                            String YWQY,//	业务区域
                                            String DWJC//业务案例
        );


    }
}
