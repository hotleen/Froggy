package com.runoob.froggy.ui.activity;

import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;

public class NoneFullActivity extends FroggyBaseActivity {

    @Override
    protected void initView() {
        Window window = getWindow();
        // 把 DecorView 的默认 padding 取消，同时 DecorView 的默认大小也会取消
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置宽度
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);
        // 给 DecorView 设置背景颜色，很重要，不然导致 Dialog 内容显示不全，有一部分内容会充当 padding，上面例子有举出
        window.getDecorView().setBackgroundColor(Color.GREEN);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nonefull;
    }
}
