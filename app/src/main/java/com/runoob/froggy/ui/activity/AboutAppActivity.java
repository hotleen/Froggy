package com.runoob.froggy.ui.activity;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;

public class AboutAppActivity extends FroggyBaseActivity {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_close);
    }
}
