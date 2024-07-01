package com.runoob.froggy.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;
import com.runoob.froggy.ui.listner.GestureListener;

public class AboutAppActivity extends FroggyBaseActivity {

    public static final String TAG = "AboutAppActivity";

    private GestureDetector gestureDetector;

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

    public void showDialog(View v) {
        gestureDetector = new GestureDetector(this, new GestureListener());


        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialog);
        View bottomView = LayoutInflater.from(this).inflate(R.layout.layout_bottom_sheet, null);
        bottomSheetDialog.setContentView(bottomView);

        TextView view = bottomView.findViewById(R.id.tv_first);
        Log.i(TAG, "find first textView: "+view);
        view.setOnTouchListener((v1, event) -> gestureDetector.onTouchEvent(event));

        TextView view2 = bottomView.findViewById(R.id.tv_second);
        Log.i(TAG, "second textView: "+view2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams = bottomView.getLayoutParams();
                layoutParams.height = (int) (Resources.getSystem().getDisplayMetrics().heightPixels * 0.5);
                bottomView.setLayoutParams(layoutParams);

                BottomSheetBehavior<View> behavior = BottomSheetBehavior.from((View) bottomView.getParent());
                behavior.setPeekHeight((int) (Resources.getSystem().getDisplayMetrics().heightPixels * 0.5));
            }
        });
        TextView view3 = bottomView.findViewById(R.id.tv_third);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        // 设置 BottomSheetDialog 的高度为屏幕的一半                 layoutParams.height = Resources.getSystem().getDisplayMetrics().heightPixels / 2;
        bottomView.post(() -> {
            ViewGroup.LayoutParams layoutParams = bottomView.getLayoutParams();
            // 可以减去status bar
            layoutParams.height = (int) (Resources.getSystem().getDisplayMetrics().heightPixels * 0.75);
            bottomView.setLayoutParams(layoutParams);

            BottomSheetBehavior<View> behavior = BottomSheetBehavior.from((View) bottomView.getParent());
            behavior.setPeekHeight((int) (Resources.getSystem().getDisplayMetrics().heightPixels * 0.75));

            // 禁止滑动
            behavior.setHideable(false);
            behavior.setDraggable(false);


        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();

    }
}
