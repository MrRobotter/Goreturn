package com.joinyon.houge.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.adapter.CategoryAdapter;
import com.joinyon.houge.base.BaseBean;
import com.joinyon.houge.bean.DicListBean;
import com.joinyon.houge.mvp.contract.InfoContract;
import com.joinyon.houge.mvp.model.InfoModel;
import com.joinyon.houge.mvp.presenter.InfoPresenter;
import com.joinyon.houge.utils.JsonUtil;
import com.joinyon.houge.utils.SPHelper;
import com.joinyon.houge.utils.Utils;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;


import fule.com.mywheelview.bean.AddressDetailsEntity;
import fule.com.mywheelview.bean.AddressModel;
import fule.com.mywheelview.weight.wheel.ChooseAddressWheel;
import fule.com.mywheelview.weight.wheel.OnAddressChangeListener;

public class BaseInfoActivity extends BaseActivity<InfoPresenter, InfoModel> implements InfoContract.View, View.OnClickListener {
    private LinearLayout llCheckFemale;
    private LinearLayout llCheckMale;
    private GridView gridView;
    private List<String> dataList = new ArrayList<>();
    private CategoryAdapter adapter;
    private ChooseAddressWheel chooseAddressWheel;
    private String address;
    private TextView etCity, edCategory;//地区
    private String XB = "男";
    private DrawerLayout drawerLayout;
    private EditText editName, etEmail, editCom, editSimpleCom,
            etWorkAddress, etDepartment, edPosition;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_info;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        String address = Utils.readAssert(this, "address.txt");
        AddressModel model = JsonUtil.parseJson(address, AddressModel.class);
        if (model != null) {
            AddressDetailsEntity data = model.Result;
            if (data == null) return;
            if (data.ProvinceItems != null && data.ProvinceItems.Province != null) {
                chooseAddressWheel.setProvince(data.ProvinceItems.Province);
                chooseAddressWheel.defaultValue(data.Province, data.City, data.Area);
            }
        }
    }

    @Override
    public void initView() {
        edCategory = findViewById(R.id.edCategory);
        editName = findViewById(R.id.editName);
        etEmail = findViewById(R.id.etEmail);
        editCom = findViewById(R.id.editCom);
        etCity = findViewById(R.id.etCity);
        editSimpleCom = findViewById(R.id.editSimpleCom);
        etWorkAddress = findViewById(R.id.etWorkAddress);
        etDepartment = findViewById(R.id.etDepartment);
        edPosition = findViewById(R.id.edPosition);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        initWheel();//初始化地址选择器
        initData();
        llCheckMale = findViewById(R.id.llCheckMale);
        llCheckFemale = findViewById(R.id.llCheckFemale);
        llCheckFemale.setOnClickListener(this);
        llCheckMale.setOnClickListener(this);
        llCheckMale.setSelected(true);
        gridView = findViewById(R.id.gridView);
//
//        StringBuilder categoryBuilder = new StringBuilder();
//        InputStream inputStream = null;
//        try {
//            inputStream = getResources().getAssets().open("category.json");
//            InputStreamReader isr = new InputStreamReader(inputStream);
//            BufferedReader reader = new BufferedReader(isr);
//            String jsonLine;
//            while ((jsonLine = reader.readLine()) != null) {
//                categoryBuilder.append(jsonLine);
//            }
//            reader.close();
//            isr.close();
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String result = categoryBuilder.toString();
//        Log.d("json", result);
//        try {
//            JSONArray jsonArray = new JSONArray(result);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                dataList.add(jsonArray.getString(i));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        mPresenter.getDicList("dwlb");


    }

    /**
     * 初始化地址
     */
    private void initWheel() {
        chooseAddressWheel = new ChooseAddressWheel(this);
        chooseAddressWheel.setOnAddressChangeListener(new OnAddressChangeListener() {
            @Override
            public void onAddressChange(String province, String city, String district) {
                address = (province + " " + city + " " + district);
                etCity.setText(address);
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llCheckFemale:
                llCheckMale.setSelected(false);
                llCheckFemale.setSelected(true);
                XB = "男";
                break;

            case R.id.llCheckMale:
                llCheckMale.setSelected(true);
                llCheckFemale.setSelected(false);
                XB = "女";
                break;

            default:
                break;
        }
    }

    /**
     * 基本信息提交
     *
     * @param view
     */
    public void submit(View view) {
        if (TextUtils.isEmpty(editName.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "姓名不能为空!");
            showSoftInputFromWindow(this, editName);
            return;
        }
        if (TextUtils.isEmpty(etEmail.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "邮箱不能为空!");
            showSoftInputFromWindow(this, etEmail);
            return;
        }

        if (TextUtils.isEmpty(etCity.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择所在省市区!");
            //showSoftInputFromWindow(this, etEmail);
            chooseAddressWheel.show(etCity);
            return;
        }

        if (TextUtils.isEmpty(editCom.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入单位名称!");
            showSoftInputFromWindow(this, editCom);

            return;
        }

        if (TextUtils.isEmpty(editSimpleCom.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入单位简称!");
            showSoftInputFromWindow(this, editSimpleCom);
            return;
        }

        if (TextUtils.isEmpty(etWorkAddress.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入工作地址!");
            showSoftInputFromWindow(this, etWorkAddress);
            return;
        }
        if (TextUtils.isEmpty(etDepartment.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入所属部门!");
            showSoftInputFromWindow(this, etDepartment);
            return;
        }

        if (TextUtils.isEmpty(edPosition.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请输入您的职位!");
            showSoftInputFromWindow(this, edPosition);
            return;
        }

        if (TextUtils.isEmpty(edCategory.getText().toString().trim())) {
            ToastUtils.showShortToast(this, "请选择您的单位类别!");
            drawerLayout.openDrawer(Gravity.RIGHT);
            return;
        }

        mPresenter.changeInformation(SPHelper.getUid(),
                "2",
                editName.getText().toString().trim(),
                XB,
                etCity.getText().toString().trim(),
                etEmail.getText().toString().trim(),
                editCom.getText().toString().trim(),
                editSimpleCom.getText().toString().trim(),
                etWorkAddress.getText().toString().trim(),
                etDepartment.getText().toString().trim(),
                edPosition.getText().toString().trim(),
                edCategory.getText().toString().trim()
        );
    }

    public void btnAddress(View view) {
        chooseAddressWheel.show(view);
    }

    public void openDrawer(View view) {
        drawerLayout.openDrawer(Gravity.RIGHT);
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

    @Override
    public void onChangeInformation(BaseBean bean) {
        if (bean != null) {
            if (bean.getResultCode().equals("1")) {
                SPHelper.setZCbz("2");
                Intent intent = new Intent(this, BusinessInfoActivity.class);
                startActivity(intent);
            }
        } else {
            ToastUtils.showShortToast(this, "提交失败!");
        }
    }

    @Override
    public void onGetDicList(final DicListBean dicListBean) {
        if (dicListBean.getResultList() == null) {
            return;
        }

        if (dicListBean.getResultList().size() == 0) {
            return;
        }
        adapter = new CategoryAdapter(this, dicListBean.getResultList());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setPosition(i);
                adapter.notifyDataSetChanged();
                edCategory.setText(dicListBean.getResultList().get(i).getValue());
            }
        });
    }

    @Override
    public void onChangeBusiness(BaseBean baseBean) {

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

    public void close(View view) {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }


    public void reset(View view) {
        adapter.setPosition(0);
        adapter.notifyDataSetChanged();
        edCategory.setText(dataList.get(0));
    }

    public void confirm(View view) {
        drawerLayout.closeDrawer(Gravity.RIGHT);
    }
}
