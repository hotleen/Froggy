package com.runoob.froggy.ui.fragment;

import com.runoob.froggy.R;
import com.runoob.froggy.base.BaseActivity;
import com.runoob.froggy.base.BaseFragment;

public final class HomeFragment<A extends BaseActivity> extends BaseFragment<A> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
