package com.joinyon.houge.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.xusangbo.basemoudle.base.BaseActivity;
import com.xusangbo.basemoudle.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */
public class FragmentSwitchUtils {

    private Context mContext;

    List<FragmentSwitchBean> mFragments;

    private BaseActivity baseActivity;

    /**
     * Fragment父布局 id
     */
    private int mVIewId;

    /**
     * 是否生成成功
     */
    private boolean isGenerateSuccess = true;
    /**
     * 当前Fragment的索引
     */

    private int currFragmentPosition;

    /**
     * @param context
     * @param fragments
     * @param viewId
     */
    public FragmentSwitchUtils(Context context, List<FragmentSwitchBean> fragments, int viewId) {
        mContext = context;
        mFragments = fragments;
        mVIewId = viewId;
        try {
            baseActivity = (BaseActivity) mContext;
            //若数量为0 则设置成 false
            if (mFragments.size() == 0) {
                isGenerateSuccess = false;
            }
        } catch (Exception e) {
            //代表转换异常工具类生成失败
            isGenerateSuccess = false;
        }


    }

    /**
     * 切换Fragment
     *
     * @param position List中的索引
     */
    public void switchFragment(int position) {
        if (isGenerateSuccess) {
            currFragmentPosition = position;
            hideFragments();
            //生成成功
            FragmentManager sf = baseActivity.getSupportFragmentManager();
            Fragment fragment = sf.findFragmentByTag(mFragments.get(position).fragmentTag);
            FragmentTransaction st = sf.beginTransaction();
            if (fragment == null) {
                //添加
                st.add(mVIewId, mFragments.get(position).fragment, mFragments.get(position).fragmentTag);
            } else {
                st.show(fragment);
            }
            if (baseActivity != null) {
                st.commit();
            }
        } else {
            Log.e("FragmentSwitchUtils", "出现错误请检查代码！");
        }
    }

    /**
     * 隐藏所有Fragment
     */
    private void hideFragments() {
        for (FragmentSwitchBean fragmentSwitchBean
                : mFragments) {
            FragmentManager sf = baseActivity.getSupportFragmentManager();
            Fragment fragment = sf.findFragmentByTag(fragmentSwitchBean.getFragmentTag());
            if (fragment != null) {
                FragmentTransaction st = sf.beginTransaction();
                st.hide(fragment);
                st.commit();
            }
        }
    }

    /**
     * 移除Fragment
     */
    public void removeFragment(int position) {
        FragmentManager sf = baseActivity.getSupportFragmentManager();
        FragmentTransaction ft = sf.beginTransaction();
        ft.remove(mFragments.get(position).fragment);
        ft.commit();
    }

    /**
     * 返回当前显示的Fragment的 索引
     *
     * @return
     */
    public int reCurrFragmentPosition() {
        return currFragmentPosition;
    }

    /**
     * 写个内部类用来封装每一个Fragment
     */
    public static class FragmentSwitchBean {
        //notice 后期要换成BaseFragment
        private BaseFragment fragment;

        private String fragmentTag;

        public FragmentSwitchBean(BaseFragment fragment, String fragmentTag) {
            this.fragment = fragment;
            this.fragmentTag = fragmentTag;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(BaseFragment fragment) {
            this.fragment = fragment;
        }

        public String getFragmentTag() {
            return fragmentTag;
        }

        public void setFragmentTag(String fragmentTag) {
            this.fragmentTag = fragmentTag;
        }
    }
}
