package com.charles.sample.main.presenter;

import com.charles.common.presenter.BasePresenterImp;
import com.charles.common.view.BaseActivity;
import com.charles.sample.main.IMainView;
import com.charles.sample.main.MainPresenter;

/**
 * MainPresenterImp
 *
 * @author Just.T
 * @since 16/12/27
 */
public class MainPresenterImp extends BasePresenterImp<IMainView> implements MainPresenter {


    public MainPresenterImp(BaseActivity activity, IMainView view) {
        super(activity, view);
    }


    public void test() {
        log("----------test---------");
        view.setText("hello world");

    }

}
