package com.joinyon.houge.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.joinyon.houge.R;
import com.joinyon.houge.adapter.CategoryAdapter;
import com.xusangbo.basemoudle.base.BaseActivity;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseInfoActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout llCheckFemale;
    private LinearLayout llCheckMale;
    private GridView gridView;
    private List<String> dataList = new ArrayList<>();
    private CategoryAdapter adapter;

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

    @Override
    public void initView() {
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
}
