package com.joinyon.houge.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import com.joinyon.houge.R;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.mvp.contract.UserTpUploadContract;
import com.joinyon.houge.mvp.model.UserTpUploadModel;
import com.joinyon.houge.mvp.presenter.UserTpUploadPresenter;
import com.joinyon.houge.utils.ImageUtil;
import com.joinyon.houge.utils.SPHelper;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelector;

/**
 * 身份认证  4-上传身份证
 */
public class IDCardIdentification extends BaseActivity<UserTpUploadPresenter, UserTpUploadModel> implements UserTpUploadContract.View {
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    private static final int REQUEST_IMAGE_FRONT = 200;
    private static final int REQUEST_IMAGE_BACK = 201;
    private ArrayList<String> mSelectPath;
    private int select;
    private ImageView ivFront, ivBack;
    private String imageFront = "", imageBack = "";
    private int count;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_id_card_indentification;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        ivBack = findViewById(R.id.ivBack);
        ivFront = findViewById(R.id.ivFront);

    }

    public void back(View view) {
        onBackPressed();
    }

    public void skip(View view) {
        Intent intent = new Intent(this, FriendsIdentification.class);
        startActivity(intent);
    }

    public void submit(View view) {
        if (TextUtils.isEmpty(imageFront)) {
            ToastUtils.showShortToast(this, "请选择身份证正面照片");
            return;
        }

        if (TextUtils.isEmpty(imageBack)) {
            ToastUtils.showShortToast(this, "请选择身份证反面照片");
            return;
        }

        mPresenter.userTpUpload(imageFront, "3", SPHelper.getUid(), "4");
    }

    @Override
    public void onUserTpUpload(BaseBean bean) {
        count++;
        if (count == 1) {
            mPresenter.userTpUpload(imageBack, "4", SPHelper.getUid(), "4");
        } else {
            if (bean.getResultCode().equals("1")) {
                SPHelper.setZCbz("5");
                Intent intent = new Intent(this, FriendsIdentification.class);
                startActivity(intent);
            }
        }

        if (bean != null) {

        } else {
            ToastUtils.showShortToast(this, "图片上传失败，请稍后重试!");
        }
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    /**
     * 选择反面
     *
     * @param view
     */
    public void selectBack(View view) {
        select = REQUEST_IMAGE_BACK;
        selectMulti(select);
    }

    /**
     * 选择正面
     *
     * @param view
     */
    public void selectFront(View view) {
        select = REQUEST_IMAGE_FRONT;
        selectMulti(select);

    }


    private void selectMulti(int code) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                    getString(R.string.mis_permission_rationale),
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            MultiImageSelector selector = MultiImageSelector.create(IDCardIdentification.this);
            selector.showCamera(true);
            selector.count(1);
            selector.multi();
            selector.start(IDCardIdentification.this, code);
        }
    }


    private void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.mis_permission_dialog_title)
                    .setMessage(rationale)
                    .setPositiveButton(R.string.mis_permission_dialog_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(IDCardIdentification.this, new String[]{permission}, requestCode);
                        }
                    })
                    .setNegativeButton(R.string.mis_permission_dialog_cancel, null)
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_STORAGE_READ_ACCESS_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectMulti(select);
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_FRONT) {
            if (resultCode == RESULT_OK) {
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                String path = mSelectPath.get(0);
                File file = new File(path);
                Bitmap bmp = ImageUtil.getResizedImage(file.getAbsolutePath(), null, 500, true, 0);
                ivFront.setImageBitmap(bmp);
                imageFront = imgToBase64(bmp, 100);
            }
        }

        if (requestCode == REQUEST_IMAGE_BACK) {
            if (resultCode == RESULT_OK) {
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                String path = mSelectPath.get(0);
                File file = new File(path);
                Bitmap bmp = ImageUtil.getResizedImage(file.getAbsolutePath(), null, 500, true, 0);
                ivBack.setImageBitmap(bmp);
                imageBack = imgToBase64(bmp, 100);
            }
        }
    }

    /**
     * 压缩图片并且转换为字符串
     *
     * @return
     */
    public String imgToBase64(Bitmap bitmap, int size) {
        if (bitmap == null) {
            return "";
        }
        size = 0 == size ? 100 : size;
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            int options = 100;
            while (out.toByteArray().length / 1024 > size) {
                options -= 10;// 每次都减少10
                out.reset();// 重置baos即清空baos
                bitmap.compress(Bitmap.CompressFormat.JPEG, options, out);
            }
            out.flush();
            out.close();
            byte[] imgBytes = out.toByteArray();
            return Base64.encodeToString(imgBytes, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
