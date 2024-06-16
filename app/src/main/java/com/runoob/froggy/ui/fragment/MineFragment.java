package com.runoob.froggy.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;
import com.runoob.froggy.base.BaseFragment;
import com.runoob.froggy.ui.activity.AboutAppActivity;

public class MineFragment<A extends FroggyBaseActivity> extends BaseFragment<A> {

    private static final String TAG = MineFragment.class.getSimpleName();

    /**
     * @noinspection rawtypes
     */
    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected void initView() {
        TextView about = findViewById(R.id.about_area);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: about");
                //todo: 抽取activityAction
                Intent intent = new Intent(getActivity(), AboutAppActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.activity_open, 0);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: mine destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: mine");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: mine");
    }
}
