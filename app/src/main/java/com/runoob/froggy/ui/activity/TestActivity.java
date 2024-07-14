package com.runoob.froggy.ui.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import com.runoob.base.activity.FroggyBaseActivity;
import com.runoob.froggy.R;

public class TestActivity extends FroggyBaseActivity {

    private final static String TAG = TestActivity.class.getSimpleName();

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final int READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 2;
    private static final int READ_MEDIA_STORAGE_PERMISSION_REQUEST_CODE = 3;

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
        return R.layout.activity_test;
    }

    public void getLocationPermission(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            // 权限已经被授予
            Log.i(TAG, "getLocationPermission: location permission granted!");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 权限被授予
                Log.i(TAG, "getLocationPermission: location permission granted!");
            } else {
                Log.i(TAG, "getLocationPermission: location permission not granted!");
            }
        }
        if (requestCode == READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 权限被授予
                Log.i(TAG, "getLocationPermission: external storage permission granted!");
            } else {
                // 权限被拒绝
                Log.i(TAG, "getLocationPermission: external storage permission not granted!");
            }
        }
        if (requestCode == READ_MEDIA_STORAGE_PERMISSION_REQUEST_CODE) {
            Log.i(TAG, "onRequestPermissionsResult: media grant "+grantResults[0]);
        }
    }

    public void getExternalPermission(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        } else {
            // 权限已经被授予
            Log.i(TAG, "getLocationPermission: external storage permission granted!");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public void getNewStoragePermission(View view) {
        Log.i(TAG, "getNewStoragePermission: api level: "+Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VIDEO)
                    != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO
                                , Manifest.permission.READ_MEDIA_AUDIO},
                        READ_MEDIA_STORAGE_PERMISSION_REQUEST_CODE);
            } else {
                // 权限已经被授予
                Log.i(TAG, "getLocationPermission: external storage permission granted!");
            }
        }
    }
}
