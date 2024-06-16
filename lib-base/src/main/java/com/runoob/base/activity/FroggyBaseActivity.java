package com.runoob.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;

public abstract class FroggyBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivity();
    }

    protected void initActivity() {
        initLayout();
        initView();
        initData();
        initAction();
    }

    /**
     * 初始化布局
     */
    protected void initLayout() {
        if (getLayoutId() > 0) {
            //这个写法可以学习一下 父类统一初始化layout
            setContentView(getLayoutId());
        }

        if (isStatusBarEnabled()) {
            ImmersionBar.with(this).init();
        }
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    protected abstract void initAction();



    /**
     * 获取布局 ID
     */
    protected abstract int getLayoutId();

    protected boolean isStatusBarEnabled() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
