package com.charles.common.view;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.charles.common.presenter.BasePresenter;
import com.charles.myapplication.BuildConfig;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import butterknife.ButterKnife;
import butterknife.Unbinder;


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
    private Unbinder mUnbind;
    private View mRootView;
    private boolean viewCreated;


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
        if (null == mRootView) {
            mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            int layoutResId = getContetView();
            if (layoutResId > 0)
                mRootView = inflater.inflate(getContetView(), container, false);
            mRootView.setOnTouchListener((v, event) -> true);
        }
        mUnbind = ButterKnife.bind(this, mRootView);
        return mRootView;
    }


    @Override
    public void showDialog(Dialog dialog) {
        mActivity.showDialog(dialog);
    }

    @Override
    public void showToast(String str) {
        mActivity.showToast(str);
    }

    @Override
    public void hideDialog(Dialog dialog) {
        mActivity.hideDialog(dialog);
    }


    @Override
    final public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!viewCreated) {
            viewCreated = true;
            initData();
        }
    }


    @Override
    final public void onViewCreated(View view, Bundle savedInstanceState) {
        if (viewCreated) {
            initView();
            viewCreated = false;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 解决ViewPager中的问题
        if (null != mRootView) {
            ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        }
        mUnbind.unbind();
    }


    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getContetView();

}
