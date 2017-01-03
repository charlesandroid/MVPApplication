package com.charles.common.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charles.common.presenter.BasePresenter;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * com.charles.common.view.BaseFragment
 *
 * @author Just.T
 * @since 16/12/28
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    private final String TAG = getClass().getSimpleName();
    protected BaseActivity mActivity;
    protected P mPresenter;
    private View mRootView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) getActivity();
        initPresenter();
    }

    protected void initPresenter() {

        try {
            Class aClass = getClass();
            Type presenterType = aClass.getGenericSuperclass();
            Type[] presenterParams = ((ParameterizedType) presenterType).getActualTypeArguments();
            Class presenterClass = (Class) presenterParams[0];
            Type viewType = presenterClass.getGenericSuperclass();
            Type[] viewParams = ((ParameterizedType) viewType).getActualTypeArguments();
            Class viewClass = (Class) viewParams[0];
            Constructor constructor = presenterClass.getConstructor(BaseActivity.class, viewClass);
            constructor.setAccessible(true);
            mPresenter = (P) constructor.newInstance(mActivity, this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    final public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutResId = getContetView();
        if (layoutResId > 0)
            mRootView = inflater.inflate(getContetView(), container, false);
        return mRootView;
    }


    @Override
    final public void onViewCreated(View view, Bundle savedInstanceState) {
        init();
    }

    @Override
    public void log(String log) {
        Log.d(TAG, log);
    }

    protected abstract void init();

    protected abstract int getContetView();

}
