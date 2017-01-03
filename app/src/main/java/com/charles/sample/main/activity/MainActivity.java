package com.charles.sample.main.activity;

import android.content.Intent;
import android.view.View;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.R;

public class MainActivity extends BaseActivity {


    @Override
    protected void init() {

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(mActivity, MVPActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(mActivity, MVCActivity.class));
                break;
        }
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

}
