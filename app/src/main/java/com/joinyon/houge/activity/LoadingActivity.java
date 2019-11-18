package com.joinyon.houge.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.joinyon.houge.utils.SPHelper;


/**
 * 启动页
 */
public class LoadingActivity extends AppCompatActivity implements View.OnClickListener {
    public static int screenWidth;// 屏幕宽度，单位为px
    public static int screenHeight;// 屏幕高度，单位为px

    /**
     * 当前设备与给定图片的基准设备放大或缩小倍数
     */
    public static double scaleRate_W;
    public static double scaleRate;

    private boolean isFirst = true;

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()) {
            finish();
            return;
        }

        initStatusBar();
        setContentView(R.layout.activity_loading);
//      PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, Constant.BAIDU_PUSH_ID);
        getScreenMatrix();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                String firstNum = SPHelper.getFirstIndex();

                if (!firstNum.equals("1")) {
                    SPHelper.setFirstIndex("1");//第一次登陆
                    //第一次
                    Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    String uid = SPHelper.getUid();
                    if (TextUtils.isEmpty(uid)) {
                        Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String zcbz = SPHelper.getZCbz();
                        if (zcbz.equals("1")) {//1-填写基本信息
                            Intent intent = new Intent(LoadingActivity.this, BaseInfoActivity.class);
                            startActivity(intent);
                            finish();
                        } else if (zcbz.equals("2")) {//2-填写业务信息
                            Intent intent = new Intent(LoadingActivity.this, BusinessInfoActivity.class);
                            startActivity(intent);
                            finish();

                        } else if (zcbz.equals("3") || zcbz.equals("4") || zcbz.equals("5")) {//3-上传名片
                            Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        }, 3000);
    }


    /**
     * 获取屏幕分辨率大小
     */
    private void getScreenMatrix() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        SPHelper.setScreenHeight(screenHeight);
        SPHelper.setScreenWidth(screenWidth);
        /** 屏幕放大和缩小的宽高四舍五入计算 */
        scaleRate_W = screenWidth * 1.0 / 750;
        scaleRate = screenHeight * 1.0 / 1334;
        SPHelper.setScaleRate((float) scaleRate);
        SPHelper.setScaleRate_W((float) scaleRate_W);

        System.out.println("screenW=" + screenWidth + " screenH="
                + screenHeight + " scaleRate_W=" + scaleRate_W
                + " scaleRate_H=" + scaleRate);
    }

    @Override
    public void onClick(View v) {
    }
}
