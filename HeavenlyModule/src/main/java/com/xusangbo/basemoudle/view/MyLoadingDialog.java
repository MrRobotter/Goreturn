package com.xusangbo.basemoudle.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.xusangbo.basemodule.R;


/**
 * Created by zx on 2015/8/14.
 */
public class MyLoadingDialog extends Dialog implements View.OnClickListener {

    public MyLoadingDialog(Context context) {
        super(context);
    }

    public MyLoadingDialog(Context context, int theme) {
        super(context, theme);
    }

    protected MyLoadingDialog(Context context, boolean cancelable,
                              OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}
