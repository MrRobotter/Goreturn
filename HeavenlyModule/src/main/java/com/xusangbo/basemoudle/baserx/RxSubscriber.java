package com.xusangbo.basemoudle.baserx;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.xusangbo.basemodule.R;
import com.xusangbo.basemoudle.base.BaseApplication;
import com.xusangbo.basemoudle.utils.NetWorkUtils;
import com.xusangbo.basemoudle.view.MyLoadingDialog;

import io.reactivex.subscribers.DisposableSubscriber;


/********************
 * 使用例子
 ********************/
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class RxSubscriber<T> extends DisposableSubscriber<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog = true;
    //    private MyLoadingDialog progressDialog;
    private ProgressDialog progressDialog;

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("请稍候,正在加载...");
        progressDialog.setCancelable(true);

//        progressDialog = new MyLoadingDialog(context, R.style.loading_dialog);// 创建自定义样式dialog
//        progressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
    }

    public RxSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), false);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), showDialog);
    }

    public RxSubscriber(Context context, boolean showDialog, String content) {
        this(context, content, showDialog);
    }

    @Override
    public void onComplete() {
        if (showDialog)
            progressDialog.dismiss();
    }


    @Override
    public void onStart() {
        super.onStart();
        if (showDialog) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }


    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog) {
            progressDialog.dismiss();
        }
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}
