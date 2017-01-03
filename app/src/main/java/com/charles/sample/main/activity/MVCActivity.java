package com.charles.sample.main.activity;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.R;

/**
 * com.charles.sample.main.activity.MVCActivity
 *
 * @author Just.T
 * @since 17/1/3
 */
public class MVCActivity extends BaseActivity {
    @Override
    protected void init() {
        mPresenter.log("MVCActivity   presenter not null!!!!");
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_mvc;
    }
}
