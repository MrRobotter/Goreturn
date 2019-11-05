package com.joinyon.houge.mvp.contract;

import android.content.Context;

import com.xusangbo.basemoudle.base.BaseModel;
import com.xusangbo.basemoudle.base.BasePresenter;
import com.xusangbo.basemoudle.base.BaseView;


public interface MainContract {

    abstract static class Presenter extends BasePresenter<View, Model> {
     public abstract void initFragment(Context context, int mainTabContent);

        public abstract  void switchFragment(int position);
    }

    interface View extends BaseView {

    }

    interface Model extends BaseModel {
    }
}
