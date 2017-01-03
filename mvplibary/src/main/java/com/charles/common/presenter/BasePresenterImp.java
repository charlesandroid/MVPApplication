package com.charles.common.presenter;

import android.util.Log;

import com.charles.common.view.BaseActivity;
import com.charles.common.view.IBaseView;

/**
 * com.charles.common.presenter.BasePresenterImp
 *
 * @author Just.T
 * @since 16/12/27
 */
public class BasePresenterImp<V extends IBaseView> implements BasePresenter {
    private final String TAG = getClass().getSimpleName();
    protected BaseActivity activity;
    protected V view;

    public BasePresenterImp(BaseActivity activity, V view) {
        this.activity = activity;
        this.view = view;
    }

    public void log(String log) {
        Log.d(TAG, log);
    }
}
