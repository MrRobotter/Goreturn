package com.joinyon.houge.fragment.sub;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joinyon.houge.MainActivity;
import com.joinyon.houge.R;
import com.joinyon.houge.adapter.CapitalAdapter;
import com.joinyon.houge.bean.AdverListBean;
import com.joinyon.houge.bean.BusinessListBean;
import com.joinyon.houge.mvp.contract.BusinessContract;
import com.joinyon.houge.mvp.model.BuinessModel;
import com.joinyon.houge.mvp.presenter.BuinessPresenter;
import com.joinyon.houge.widget.banner.CBViewHolderCreator;
import com.joinyon.houge.widget.banner.ConvenientBanner;
import com.joinyon.houge.widget.banner.LocalImageHolderView;
import com.joinyon.houge.widget.banner.NetworkImageHolderView;
import com.xusangbo.basemoudle.base.BaseFragment;
import com.xusangbo.basemoudle.base.BaseModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link } subclass.
 * 资金
 */
public class CapitalFragment extends BaseFragment<BuinessPresenter, BuinessModel> implements BusinessContract.View {
    public MainActivity activity;
    private String type;
    private RecyclerView recyclerView;
    private CapitalAdapter adapter;
    private List<BusinessListBean.ResultListBean> dataList = new ArrayList<>();
    private ConvenientBanner convenientBanner;

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
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
//        mPresenter.getCuserList(
//                "1",//
//                "1",//
//                "1",//
//                "",//
//                "",//
//                "",//
//                "",//
//                "",//
//                "1"//
//        );
        mPresenter.getCuserList();
        mPresenter.getAdvertisingLis("1");

        convenientBanner = activity.findViewById(R.id.convenientBanner);

        recyclerView = activity.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new CapitalAdapter(activity, dataList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onGetCuserList(BusinessListBean businessListBean) {
        if (businessListBean != null) {
            if (businessListBean.getResultList() != null && businessListBean.getResultList().size() > 0) {
                //dataList = businessListBean.getResultList();
                dataList.addAll(businessListBean.getResultList());
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onGetAdvertisingLis(AdverListBean adverListBean) {
        initBanner(adverListBean);
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
     * 实现轮播广告
     */
    private void initBanner(AdverListBean bean) {
        if (convenientBanner == null) {
            return;
        }
        List<AdverListBean.ResultListBean> imagesURLs;
        if (bean != null) {
            imagesURLs = bean.getResultList();

            if (imagesURLs != null && imagesURLs.size() > 0) {
                List<String> networkImages = new ArrayList<String>();
                for (AdverListBean.ResultListBean listBean : imagesURLs) {
                    networkImages.add(listBean.getIMG());
                }

                convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {

                        return new NetworkImageHolderView();
                    }
                }, networkImages)
                        .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})

                        .setPageTransformer(ConvenientBanner.Transformer.DefaultTransformer);
            } else {
            }

        }


    }
}
