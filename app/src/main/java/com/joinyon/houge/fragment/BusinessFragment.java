package com.joinyon.houge.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.joinyon.houge.activity.MyQRcodeActivity;
import com.joinyon.houge.activity.ScanActivity;
import com.joinyon.houge.activity.SearchActivity;
import com.joinyon.houge.adapter.BusinessAdapter;
import com.joinyon.houge.fragment.sub.CapitalFragment;
import com.joinyon.houge.widget.ScaleTransitionPagerTitleView;
import com.xusangbo.basemoudle.base.BaseFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class BusinessFragment extends BaseFragment implements View.OnClickListener {
    private MainActivity activity;
    private MagicIndicator magicIndicator;
    private ViewPager vp_content;
    public static final String[] BARGAIN_ARR = {"活动中(4)", "暂停(3)", "过期(15)"};
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();//碎片集合
    private ImageView ivScanCode, imageQR;
    private RelativeLayout rlSearch;
    private TextView tvName;


    public BusinessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_business;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        imageQR = activity.findViewById(R.id.imageQR);
        ivScanCode = activity.findViewById(R.id.ivScanCode);
        rlSearch = activity.findViewById(R.id.rlSearch);

        rlSearch.setOnClickListener(this);
        ivScanCode.setOnClickListener(this);
        imageQR.setOnClickListener(this);

        vp_content = activity.findViewById(R.id.vp_content);
        titleList.add("资金");
        titleList.add("项目");
        titleList.add("专家");
        titleList.add("有约");
        titleList.add("路演");

        for (int i = 0; i < titleList.size(); i++) {
            CapitalFragment fragment = CapitalFragment.newInstance(String.valueOf(i + 1));
            fragmentList.add(fragment);
        }
        BusinessAdapter businessAdapter = new BusinessAdapter(activity, activity.getSupportFragmentManager(), titleList, fragmentList);
        vp_content.setAdapter(businessAdapter);
        initMagicIndicator();
        vp_content.setCurrentItem(0, true);
    }

    /**
     * 初始化导航栏
     */
    private void initMagicIndicator() {
        magicIndicator = activity.findViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);

        CommonNavigator commonNavigator = new CommonNavigator(activity);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titleList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(titleList.get(index));
                simplePagerTitleView.setTextSize(20);
                simplePagerTitleView.setNormalColor(Color.parseColor("#999999"));
                simplePagerTitleView.setSelectedColor(Color.parseColor("#00C188"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_content.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setLineHeight(UIUtil.dip2px(context, 3));
                indicator.setColors(Color.parseColor("#00C188"));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, vp_content);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.imageQR:
                intent = new Intent(activity, MyQRcodeActivity.class);
                startActivity(intent);
                break;

            case R.id.ivScanCode:
                intent = new Intent(activity, ScanActivity.class);
                startActivity(intent);
                break;

            case R.id.rlSearch:
                intent = new Intent(activity, SearchActivity.class);
                startActivity(intent);

                break;
            default:
                break;

        }
    }
}
