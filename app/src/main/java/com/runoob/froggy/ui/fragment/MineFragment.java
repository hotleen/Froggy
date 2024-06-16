package com.runoob.froggy.ui.fragment;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;
import com.runoob.froggy.base.BaseFragment;

public class MineFragment <A extends FroggyBaseActivity> extends BaseFragment<A> {

    /** @noinspection rawtypes*/
    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
