package com.joinyon.houge.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class BusinessAdapter extends FragmentPagerAdapter {
    private List<String> mDataList;
    private List<Fragment> mFragmentList;


    public BusinessAdapter(Context context, FragmentManager fm, List<String> mDataList, List<Fragment> mFragmentList) {
        super(fm);
        this.mDataList = mDataList;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }


    /**
     * 设置新的数据
     *
     * @param mFragmentList
     */
    public void setFragmentData(List<Fragment> mFragmentList) {
        this.mFragmentList = mFragmentList;
        notifyDataSetChanged();
    }

    /**
     * 设置新的标题
     *
     * @param mDataList
     */
    public void setTitleData(List<String> mDataList) {
        this.mDataList = mDataList;
    }

}
