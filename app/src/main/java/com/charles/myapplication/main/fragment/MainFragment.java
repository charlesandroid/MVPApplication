package com.charles.myapplication.main.fragment;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.charles.common.view.BaseFragment;
import com.charles.myapplication.R;
import com.charles.myapplication.main.IMainView;
import com.charles.myapplication.main.presenter.MainPresenterImp;

import butterknife.BindView;

/**
 * com.charles.myapplication.main.fragment.MainFragment
 *
 * @author Just.T
 * @since 16/12/28
 */
public class MainFragment extends BaseFragment<MainPresenterImp> implements IMainView {


    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.testRetrofit();
    }

    @Override
    protected int getContetView() {
        return R.layout.activity_main;
    }

    @Override
    public void setText(String address) {
        tvText.setText("hahahahahah" + address);
    }

}
