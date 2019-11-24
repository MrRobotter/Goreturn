package com.joinyon.houge.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.adapter.BusinCateAdapter;
import com.joinyon.houge.adapter.CategoryAdapter;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.mvp.contract.InfoContract;
import com.joinyon.houge.mvp.model.InfoModel;
import com.joinyon.houge.mvp.presenter.InfoPresenter;
import com.joinyon.houge.utils.SPHelper;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

public class BusinessInfoActivity extends BaseActivity<InfoPresenter, InfoModel> implements InfoContract.View {
    private GridView gridView;
    private DrawerLayout drawerLayout;
    private CategoryAdapter businessRoleAdapter, businessTypeAdapter, businessAreaAdapter;
    private BusinCateAdapter businessFieldAdapter, businessStageAdapter;
    private TextView tvSelectTitle, tvSelectTip, etBusinessRole, etBusinessType, etBusinessField, etBusinessStage, etBusinessArea;
    private EditText etBusinessCase;
    private int tag = 0;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_business_info;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        gridView = findViewById(R.id.gridView);
        drawerLayout = findViewById(R.id.drawerLayout);
        tvSelectTitle = findViewById(R.id.tvSelectTitle);

        tvSelectTip = findViewById(R.id.tvSelectTip);
        etBusinessRole = findViewById(R.id.etBusinessRole);
        etBusinessType = findViewById(R.id.etBusinessType);

        etBusinessField = findViewById(R.id.etBusinessField);
        etBusinessStage = findViewById(R.id.etBusinessStage);
        etBusinessArea = findViewById(R.id.etBusinessArea);

        etBusinessCase = findViewById(R.id.etBusinessCase);

    }

    public void skip(View view) {
    }

    public void back(View view) {
        onBackPressed();
    }

    public void submit(View view) {
        if (TextUtils.isEmpty(etBusinessRole.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择业务角色!");
            selectBusinessRole(view);
            return;
        }

        if (TextUtils.isEmpty(etBusinessType.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择业务类型!");
            selectBusinessType(view);
            return;
        }

        if (TextUtils.isEmpty(etBusinessField.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择关注领域!");
            selectBusinessField(view);
            return;
        }

        if (TextUtils.isEmpty(etBusinessStage.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择业务阶段!");
            selectBusinessStage(view);
            return;
        }

        if (TextUtils.isEmpty(etBusinessArea.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择业务区域!");
            selectBusinessArea(view);
            return;
        }

        if (TextUtils.isEmpty(etBusinessCase.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入业务案例!");
            showSoftInputFromWindow(this, etBusinessCase);
            return;
        }


        mPresenter.changeBusiness(SPHelper.getUid(),
                "3",
                etBusinessRole.getText().toString().trim(),
                etBusinessType.getText().toString().trim(),
                etBusinessField.getText().toString().trim(),
                etBusinessStage.getText().toString().trim(),
                etBusinessArea.getText().toString().trim(),
                etBusinessCase.getText().toString().trim()
        );
    }

    public void confirm(View view) {
        drawerLayout.closeDrawer(Gravity.RIGHT);
        if (tag == 2) {
            etBusinessField.setText(businessFieldAdapter.getStrings());
        } else if (tag == 3) {
            etBusinessStage.setText(businessStageAdapter.getStrings());
        }
    }

    public void reset(View view) {
        if (tag == 0) {
            businessRoleAdapter.setPosition(0);
            businessRoleAdapter.notifyDataSetChanged();
        } else if (tag == 1) {
            businessTypeAdapter.setPosition(0);
            businessTypeAdapter.notifyDataSetChanged();
        } else if (tag == 2) {
            businessFieldAdapter.reset();
        } else if (tag == 3) {
            businessStageAdapter.reset();
        }
    }

    public void close(View view) {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }

    @Override
    public void onChangeInformation(BaseBean bean) {


    }

    @Override
    public void onGetDicList(final DicListBean dicListBean) {
        if (dicListBean.getResultList() == null) {
            return;
        }

        if (dicListBean.getResultList().size() == 0) {
            return;
        }

        if (tag == 0) {
            businessRoleAdapter = new CategoryAdapter(this, dicListBean.getResultList());
            gridView.setAdapter(businessRoleAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    businessRoleAdapter.setPosition(i);
                    businessRoleAdapter.notifyDataSetChanged();
                    etBusinessRole.setText(dicListBean.getResultList().get(i).getValue());
                }
            });
            drawerLayout.openDrawer(Gravity.RIGHT);
        } else if (tag == 1) {
            businessTypeAdapter = new CategoryAdapter(this, dicListBean.getResultList());
            gridView.setAdapter(businessTypeAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    businessTypeAdapter.setPosition(i);
                    businessTypeAdapter.notifyDataSetChanged();
                    etBusinessType.setText(dicListBean.getResultList().get(i).getValue());
                }
            });
            drawerLayout.openDrawer(Gravity.RIGHT);
        } else if (tag == 2) {
            businessFieldAdapter = new BusinCateAdapter(this, dicListBean.getResultList());
            gridView.setAdapter(businessFieldAdapter);
            drawerLayout.openDrawer(Gravity.RIGHT);
        } else if (tag == 3) {
            businessStageAdapter = new BusinCateAdapter(this, dicListBean.getResultList());
            gridView.setAdapter(businessStageAdapter);
            drawerLayout.openDrawer(Gravity.RIGHT);
        } else if (tag == 4) {
            businessAreaAdapter = new CategoryAdapter(this, dicListBean.getResultList());
            gridView.setAdapter(businessAreaAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    businessAreaAdapter.setPosition(i);
                    businessAreaAdapter.notifyDataSetChanged();
                    etBusinessArea.setText(dicListBean.getResultList().get(i).getValue());
                }
            });
            drawerLayout.openDrawer(Gravity.RIGHT);
        }
    }

    @Override
    public void onChangeBusiness(BaseBean baseBean) {
        if (baseBean != null) {
            if (baseBean.getResultCode().equals("1")) {
                SPHelper.setZCbz("3");
                Intent intent = new Intent(this, CardIdentification.class);
                startActivity(intent);
            }
        } else {
            ToastUtils.showShortToast(this, "提交失败!");
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

    public void selectBusinessRole(View view) {
        tag = 0;//业务角色
        mPresenter.getDicList("ywjs");
        tvSelectTitle.setText("请选择业务角色");
        tvSelectTip.setText("只能选择一项");
    }

    public void selectBusinessType(View view) {
        tag = 1;//业务角色
        mPresenter.getDicList("ywlxxmf");
        tvSelectTitle.setText("请选择业务类型");
        tvSelectTip.setText("只能选择一项");
    }

    public void selectBusinessField(View view) {
        tag = 2;//关注领域
        mPresenter.getDicList("gzly");
        tvSelectTitle.setText("请选择关注领域");
        tvSelectTip.setText("最多只能选择三项");
    }


    public void selectBusinessStage(View view) {
        tag = 3;//业务阶段
        mPresenter.getDicList("ywjd");
        tvSelectTitle.setText("请选择业务阶段");
        tvSelectTip.setText("最多只能选择三项");
    }

    public void selectBusinessArea(View view) {
        tag = 4;//业务区域 无此字段，后续完善
        mPresenter.getDicList("ywlb");
        tvSelectTitle.setText("请选择业务区域");
        tvSelectTip.setText("只能选择一项");
    }


    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }

}
