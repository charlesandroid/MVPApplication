package com.charles.sample.main.activity;

import android.widget.TextView;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.R;
import com.charles.sample.main.IMainView;
import com.charles.sample.main.presenter.MainPresenterImp;

/**
 * com.charles.sample.main.activity.MVPActivity
 *
 * @author Just.T
 * @since 17/1/3
 */
public class MVPActivity extends BaseActivity<MainPresenterImp> implements IMainView {

    private TextView textView;

    @Override
    protected void init() {
        textView = (TextView) findViewById(R.id.textView);
        mPresenter.test();
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_mvp;
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}
