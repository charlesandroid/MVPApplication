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
public abstract class BasePresenterImp<V extends IBaseView> implements BasePresenter {
    private final String TAG = getClass().getSimpleName();
    protected BaseActivity activity;
    protected V view;

    public BasePresenterImp(BaseActivity activity, V view) {
        this.activity = activity;
        this.view = view;
    }

<<<<<<< HEAD:mvplibary/src/main/java/com/charles/common/presenter/BasePresenterImp.java
    public void log(String log) {
        Log.d(TAG, log);
=======

    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
>>>>>>> parent of d40d236... no message:app/src/main/java/com/charles/common/presenter/BasePresenterImp.java
    }
}
