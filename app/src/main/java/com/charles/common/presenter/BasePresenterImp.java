package com.charles.common.presenter;

import android.util.Log;

import com.charles.common.view.BaseActivity;
import com.charles.common.view.IBaseView;
import com.charles.myapplication.BuildConfig;

/**
 * com.charles.common.presenter.BasePresenterImp
 *
 * @author Just.T
 * @since 16/12/27
 */
public abstract class BasePresenterImp<V extends IBaseView> implements BasePresenter {
    private final String TAG = getClass().getSimpleName();
    protected BaseActivity activity;
    protected V view;

    public BasePresenterImp(BaseActivity activity, V view) {
        this.activity = activity;
        this.view = view;
    }


    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }
}
