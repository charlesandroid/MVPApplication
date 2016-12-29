package com.charles.myapplication.network;

import android.util.Log;

import com.charles.myapplication.BuildConfig;

import rx.Subscriber;

/**
 * com.charles.myapplication.network.ResponseSubscriber
 * 网络请求结果的Subscriber基类
 *
 * @author Just.T
 * @since 16/12/26
 */
public abstract class ResponseSubscriber<T> extends Subscriber<Response<T>> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(Response<T> t) {
        if (BuildConfig.DEBUG) {
            Log.d(getClass().getSimpleName(), t.toString());
        }
        if (t.code == 0) {
            success(t.data);
        } else {
            fail(t);
        }
    }

    public abstract void success(T t);

    public abstract void fail(Response t);

}