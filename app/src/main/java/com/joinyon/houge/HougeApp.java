package com.joinyon.houge;

import android.content.Context;

import com.joinyon.houge.utils.SPHelper;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
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
        initImageLoader();
    }

    /**
     * 初始化网络图片缓存库
     */
    private void initImageLoader() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.drawable.luyan)
                .cacheInMemory(true)
                .cacheOnDisk(false)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).
                defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }
}
