package com.joinyon.houge.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joinyon.houge.R;
import com.joinyon.houge.adapter.CategoryAdapter;
import com.joinyon.houge.utils.JsonUtil;
import com.joinyon.houge.utils.Utils;
import com.xusangbo.basemoudle.base.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import fule.com.mywheelview.bean.AddressDetailsEntity;
import fule.com.mywheelview.bean.AddressModel;
import fule.com.mywheelview.weight.wheel.ChooseAddressWheel;
import fule.com.mywheelview.weight.wheel.OnAddressChangeListener;

public class BaseInfoActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout llCheckFemale;
    private LinearLayout llCheckMale;
    private GridView gridView;
    private List<String> dataList = new ArrayList<>();
    private CategoryAdapter adapter;
    private ChooseAddressWheel chooseAddressWheel;
    private String address;
    private TextView etCity;//地区
    private DrawerLayout drawerLayout;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_info;
    }

    @Override
    public void initPresenter() {

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
        etCity = findViewById(R.id.etCity);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        initWheel();//初始化地址选择器
        initData();
        llCheckMale = findViewById(R.id.llCheckMale);
        llCheckFemale = findViewById(R.id.llCheckFemale);
        llCheckFemale.setOnClickListener(this);
        llCheckMale.setOnClickListener(this);
        llCheckFemale.setSelected(true);
        gridView = findViewById(R.id.gridView);

        StringBuilder categoryBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("category.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                categoryBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = categoryBuilder.toString();
        Log.d("json", result);
        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                dataList.add(jsonArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        adapter = new CategoryAdapter(this, dataList);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setPosition(i);
                adapter.notifyDataSetChanged();
            }
        });

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
    }

    /**
     * 跳过
     *
     * @param view
     */
    public void skip(View view) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llCheckFemale:
                llCheckMale.setSelected(false);
                llCheckFemale.setSelected(true);

                break;

            case R.id.llCheckMale:
                llCheckMale.setSelected(true);
                llCheckFemale.setSelected(false);
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

    }

    public void btnAddress(View view) {
        chooseAddressWheel.show(view);
    }

    public void openDrawer(View view) {
        drawerLayout.openDrawer(Gravity.RIGHT);
    }
}
