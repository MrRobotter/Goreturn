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
 * 名片认证 3-上传名片
 */
public class CardIdentification extends BaseActivity<UserTpUploadPresenter, UserTpUploadModel> implements UserTpUploadContract.View {
    protected static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    private static final int REQUEST_IMAGE = 200;
    private ArrayList<String> mSelectPath;

    private ImageView ivCard;
    private String image = "";


    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_card_identification;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        ivCard = findViewById(R.id.ivCard);

    }

    public void skip(View view) {
        Intent intent = new Intent(this, IDCardIdentification.class);
        startActivity(intent);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void submit(View view) {
        if (TextUtils.isEmpty(image)) {
            ToastUtils.showShortToast(this, "请选名片照片");
            return;
        }
        mPresenter.userTpUpload(image, "2", SPHelper.getUid(), "3");
    }


    private void selectMulti() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                    getString(R.string.mis_permission_rationale),
                    REQUEST_STORAGE_READ_ACCESS_PERMISSION);
        } else {
            MultiImageSelector selector = MultiImageSelector.create(CardIdentification.this);
            selector.showCamera(true);
            selector.count(1);
            selector.multi();
            selector.start(CardIdentification.this, REQUEST_IMAGE);
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
                            ActivityCompat.requestPermissions(CardIdentification.this, new String[]{permission}, requestCode);
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
                selectMulti();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * 选择图片
     *
     * @param view
     */
    public void selectPic(View view) {
        selectMulti();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                mSelectPath = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                String path = mSelectPath.get(0);
                File file = new File(path);
                Bitmap bmp = ImageUtil.getResizedImage(file.getAbsolutePath(), null, 500, true, 0);
                ivCard.setImageBitmap(bmp);
                image = imgToBase64(bmp, 100);
            }
        }
    }

    @Override
    public void onUserTpUpload(BaseBean bean) {
        if (bean != null) {
            if (bean.getResultCode().equals("1")) {
                SPHelper.setZCbz("4");
                Intent intent = new Intent(this, IDCardIdentification.class);
                startActivity(intent);
            }
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
