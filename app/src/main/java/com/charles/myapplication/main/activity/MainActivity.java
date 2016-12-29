package com.charles.myapplication.main.activity;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.charles.common.view.BaseActivity;
import com.charles.myapplication.R;
import com.charles.myapplication.main.IMainView;
import com.charles.myapplication.main.fragment.MainFragment;
import com.charles.myapplication.main.presenter.MainPresenterImp;

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
        MainFragment myFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, myFragment).commit();
        mPresenter.testRetrofit();

    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

}
