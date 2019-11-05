package com.joinyon.houge.fragment.sub;


import android.content.Context;
import android.os.Bundle;
//import android.support.v7.widget.RecyclerView;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.xusangbo.basemoudle.base.BaseFragment;

/**
 * A simple {@link } subclass.
 */
public class CapitalFragment extends BaseFragment {
    public MainActivity activity;
    private String type;
//    private RecyclerView recyclerView;

    public static CapitalFragment newInstance(String type) {
        CapitalFragment fragment = new CapitalFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    public CapitalFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (MainActivity) context;
    }


    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_capital;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

}
