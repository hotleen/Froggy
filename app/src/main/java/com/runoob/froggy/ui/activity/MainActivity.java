package com.runoob.froggy.ui.activity;

import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.runoob.froggy.R;
import com.runoob.froggy.base.BaseActivity;
import com.runoob.froggy.ui.adapter.NavigationAdapter;

public class MainActivity extends BaseActivity implements NavigationAdapter.OnNavigationListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    // 导航
    private NavigationAdapter mNavigationAdapter;
    private RecyclerView mNavigationView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mNavigationView = findViewById(R.id.rv_home_navigation);
        mNavigationAdapter = new NavigationAdapter(this);

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

    @Override
    protected void initData() {

    }

    @Override
    public boolean onNavigationItemSelected(int position) {
        Log.i(TAG, "onNavigationItemSelected: "+position);
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
