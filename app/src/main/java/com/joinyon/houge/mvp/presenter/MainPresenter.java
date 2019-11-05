package com.joinyon.houge.mvp.presenter;

import android.content.Context;

import com.joinyon.houge.fragment.BusinessFragment;
import com.joinyon.houge.fragment.ContactsFragment;
import com.joinyon.houge.fragment.MineFragment;
import com.joinyon.houge.fragment.ServiceFragment;
import com.joinyon.houge.mvp.contract.MainContract;
import com.joinyon.houge.utils.FragmentSwitchUtils;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends MainContract.Presenter {
    private MainContract.View view;
    private FragmentSwitchUtils fragmentSwitchUtils;

    @Override
    public void initFragment(Context context, int mainTabContent) {
        List<FragmentSwitchUtils.FragmentSwitchBean> fragments = new ArrayList<>();
        fragments.add(new FragmentSwitchUtils.FragmentSwitchBean(new BusinessFragment(), "BusinessFragment"));
        fragments.add(new FragmentSwitchUtils.FragmentSwitchBean(new ContactsFragment(), "ContactsFragment"));
        fragments.add(new FragmentSwitchUtils.FragmentSwitchBean(new ServiceFragment(),"ServiceFragment"));
        fragments.add(new FragmentSwitchUtils.FragmentSwitchBean(new MineFragment(), "MineFragment"));
        fragmentSwitchUtils = new FragmentSwitchUtils(context, fragments, mainTabContent);
        fragmentSwitchUtils.switchFragment(0);
    }

    @Override
    public void switchFragment(int position) {
        if (fragmentSwitchUtils != null) {
            fragmentSwitchUtils.switchFragment(position);
        }
    }
}
