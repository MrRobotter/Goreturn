package com.joinyon.houge.mvp.contract;

import com.joinyon.houge.bean.AdverListBean;
import com.joinyon.houge.bean.BusinessListBean;
import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;

import io.reactivex.Flowable;
import retrofit2.http.Field;

public interface BusinessContract {

    interface Model extends BaseModel {
        Flowable<BusinessListBean> getCuserList(
                String YHLX,//1-资方  2-项目方  3-专家  4-平台方
                String keywords,//关键字搜索
                String PXLX,//排序类型  1-收藏量 2-转发量  3-点评分  4浏览数
                String GZLY,//关注领域  当多选时 以“；”分割传递到后台
                String YWQY,//当多选时 以“；”分割传递到后台
                String YWLX,//当多选时 以“；”分割传递到后台
                String YWJD,//务阶段  当多选时 以“；”分割传递到后台
                String SFTJ,//是否推荐  1-推荐 2-不推荐
                String currentPage////页码
        );

        Flowable<BusinessListBean> getCuserList();

        Flowable<AdverListBean> getAdvertisingLis(
                String SHOW_TYPE//所属模块 1:资方 2、项目 3、活动  4、专家
        );

    }

    interface View extends BaseView {
        void onGetCuserList(BusinessListBean businessListBean);

        void onGetAdvertisingLis(AdverListBean adverListBean);
    }


    abstract static class Presenter extends BasePresenter<View, Model> {
        public abstract void getCuserList(
                String YHLX,//1-资方  2-项目方  3-专家  4-平台方
                String keywords,//关键字搜索
                String PXLX,//排序类型  1-收藏量 2-转发量  3-点评分  4浏览数
                String GZLY,//关注领域  当多选时 以“；”分割传递到后台
                String YWQY,//当多选时 以“；”分割传递到后台
                String YWLX,//当多选时 以“；”分割传递到后台
                String YWJD,//务阶段  当多选时 以“；”分割传递到后台
                String SFTJ,//是否推荐  1-推荐 2-不推荐
                String currentPage////页码
        );

        public abstract void getCuserList();

        public abstract void getAdvertisingLis(
                String SHOW_TYPE//所属模块 1:资方 2、项目 3、活动  4、专家
        );
    }
}
