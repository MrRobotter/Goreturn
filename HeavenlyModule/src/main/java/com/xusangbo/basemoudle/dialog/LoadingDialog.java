package com.xusangbo.basemoudle.dialog;

import android.content.Context;

import com.xusangbo.basemodule.R;
import com.xusangbo.basemoudle.view.MyLoadingDialog;

/**
 * Created by boxu on 2017/4/1.
 */

public class LoadingDialog {

    /**
     * 加载进度
     */
    private static MyLoadingDialog progressDialog;

    public static final int PROGRESS_LOADING = 0;


    public static void showLoadingDialog(Context context, int type) {

        showLoadingDialog(context, type, null, 0);

    }

    public static void showLoadingDialog(Context context, int type, String message) {

        showLoadingDialog(context, type, message, 0);

    }

    public static void showLoadingDialog(Context context, int type, int drawableId) {

        showLoadingDialog(context, type, null, drawableId);
    }

    public static void showLoadingDialog(Context context, int type, String message, int drawableId) {
        if (null == context) {
            return;
        }
        switch (type) {
            case PROGRESS_LOADING:
                showProgressLoading(context);
                break;

            default:
                showProgressLoading(context);
                break;
        }
    }

    private static void showProgressLoading(Context context) {
        if (progressDialog == null) {
            progressDialog = new MyLoadingDialog(context, R.style.Custom_Progress);// 创建自定义样式dialog
            progressDialog.setCancelable(true);// 不可以用“返回键”取消
        }
        try {
            progressDialog.show();
        } catch (Exception e) {
        }
    }


    /**
     * 默认载入loading
     *
     * @param context
     */
    public static void showLoadingDialog(Context context) {
        showLoadingDialog(context, PROGRESS_LOADING);
    }

    /**
     * 取消loading
     */
    public static void cancelLoadingDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
            }
        }
        progressDialog = null;
    }


}
