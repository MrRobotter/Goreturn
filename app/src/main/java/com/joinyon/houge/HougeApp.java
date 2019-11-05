package com.joinyon.houge;

import android.content.Context;

import com.joinyon.houge.utils.SPHelper;
import com.xusangbo.basemoudle.base.BaseApplication;

public class HougeApp extends BaseApplication {

    public static HougeApp app;
    public static Context context;
    /**
     * 获取上下文
     *
     * @return Context
     */
    public static Context getContext() {
        return context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        SPHelper.init(this);
        context = getApplicationContext();
        app = this;
    }


}
