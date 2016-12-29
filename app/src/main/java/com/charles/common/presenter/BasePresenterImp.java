package com.charles.common.presenter;

import android.util.Log;

import com.charles.common.view.BaseActivity;
import com.charles.common.view.IBaseView;
import com.charles.myapplication.BuildConfig;

import org.greenrobot.eventbus.EventBus;

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

    public boolean checkActivityState() {
        return activity != null && !activity.isFinishing();
    }

    public boolean isMainThread() {
        return activity.getMainLooper().getThread().equals(Thread.currentThread());
    }

    @Override
    public void sendMessage(Object event) {
        EventBus.getDefault().post(event);
    }

    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }

}
