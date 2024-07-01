package com.runoob.froggy.ui.activity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.runoob.froggy.R;
import com.runoob.froggy.ui.listner.GestureListener;


public class BizTransparentActivity extends AppCompatActivity {
    private static final String TAG = BizTransparentActivity.class.getSimpleName();
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz);

        // 初始化 GestureDetector
        gestureDetector = new GestureDetector(this, new GestureListener());

        Window window = getWindow();
        // 把 DecorView 的默认 padding 取消，同时 DecorView 的默认大小也会取消
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置宽度
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);
        // 给 DecorView 设置背景颜色，很重要，不然导致 Dialog 内容显示不全，有一部分内容会充当 padding，上面例子有举出
//         window.getDecorView().setBackgroundColor(Color.GREEN);


        // 设置触摸监听
        RelativeLayout rootLayout = findViewById(R.id.root_layout);
        rootLayout.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

    }

}
