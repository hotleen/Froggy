package com.runoob.froggy.ui.activity;

import android.content.Intent;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;
import com.runoob.froggy.base.BaseFragment;
import com.runoob.froggy.base.FragmentPagerAdapter;
import com.runoob.froggy.ui.adapter.NavigationAdapter;
import com.runoob.froggy.ui.fragment.HomeFragment;

public class MainActivity extends FroggyBaseActivity implements NavigationAdapter.OnNavigationListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    // 导航tab
    private NavigationAdapter mNavigationAdapter;
    private RecyclerView mNavigationView;

    private ViewPager mViewPager;

    private FragmentPagerAdapter<BaseFragment<?>> mPagerAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mNavigationView = findViewById(R.id.rv_home_navigation);
        mNavigationAdapter = new NavigationAdapter(this);

        mViewPager = findViewById(R.id.vp_home_pager);

        initBottomNav();
    }

    @Override
    protected void initData() {
        mPagerAdapter = new FragmentPagerAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mViewPager.setAdapter(mPagerAdapter);

        onNewIntent(getIntent());
    }

    @Override
    protected void initAction() {

    }


    /**
     * onNewIntent 方法是 Android 应用开发中一个用于处理新的 Intent 的方法，
     * 通常在 Activity 中使用。当一个 Activity 已经启动，并且有新的 Intent
     * 传递给它时，onNewIntent 方法就会被调用
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        switchFragment(mPagerAdapter.getFragmentIndex(HomeFragment.class));
    }

    //初始化导航栏
    private void initBottomNav() {
        if (mNavigationAdapter == null || mNavigationView == null) {
            return;
        }
        mNavigationAdapter = new NavigationAdapter(this);
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_index),
                ContextCompat.getDrawable(this, R.drawable.home_home_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_found),
                ContextCompat.getDrawable(this, R.drawable.home_found_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_message),
                ContextCompat.getDrawable(this, R.drawable.home_message_selector)));
        mNavigationAdapter.addItem(new NavigationAdapter.MenuItem(getString(R.string.home_nav_me),
                ContextCompat.getDrawable(this, R.drawable.home_me_selector)));
        mNavigationAdapter.setOnNavigationListener(this);
        mNavigationView.setAdapter(mNavigationAdapter);
    }

    private void switchFragment(int fragmentIndex) {
        if (fragmentIndex == -1) {
            return;
        }

        switch (fragmentIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
                mViewPager.setCurrentItem(fragmentIndex);
                mNavigationAdapter.setSelectedPosition(fragmentIndex);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(int position) {
        Log.i(TAG, "onNavigationItemSelected: " + position);
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }
}
