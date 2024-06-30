package com.runoob.froggy.ui.activity;

import android.content.Intent;
import android.view.View;

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

    public void goNoneFull(View view) {
        Intent intent = new Intent(this, NoneFullActivity.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
    }

    public void goBizPage(View view) {
        Intent intent = new Intent(this, BizTransparentActivity.class);
        startActivity(intent);
    }
}
