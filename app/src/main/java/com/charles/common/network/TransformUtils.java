package com.charles.common.network;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * com.charles.common.network.TransformUtils
 *
 * @author Just.T
 * @since 16/12/26
 */
public class TransformUtils {

    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return tObservable -> tObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
    }

    public static <T> Observable.Transformer<T, T> all_io() {
        return tObservable -> tObservable.observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
    }
}
