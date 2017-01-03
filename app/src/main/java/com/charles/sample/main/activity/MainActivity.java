package com.charles.sample.main.activity;

import android.widget.TextView;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.R;
import com.charles.sample.main.IMainView;
import com.charles.sample.main.presenter.MainPresenterImp;

public class MainActivity extends BaseActivity<MainPresenterImp> implements IMainView {


    private TextView textView;

    @Override
    public void setText(String text) {
        textView.setText(text);
    }


    @Override
    protected void init() {
        textView = (TextView) findViewById(R.id.tv_text);
        mPresenter.test();

    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

}
