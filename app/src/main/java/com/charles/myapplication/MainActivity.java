package com.charles.myapplication;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.IMainView;
import com.charles.myapplication.MyFragment;
import com.charles.myapplication.R;
import com.charles.myapplication.MainPresenterImp;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenterImp> implements IMainView {


    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.fl)
    FrameLayout fl;


    @Override
    public void setText(String address) {
        tvText.setText(address);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        MyFragment myFragment = new MyFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, myFragment).commit();
        mPresenter.testRetrofit();

    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

}
