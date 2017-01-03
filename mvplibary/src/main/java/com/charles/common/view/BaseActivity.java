package com.charles.common.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.charles.common.presenter.BasePresenter;
<<<<<<< HEAD:mvplibary/src/main/java/com/charles/common/view/BaseActivity.java
import com.charles.common.presenter.BasePresenterImp;
=======
import com.charles.myapplication.BuildConfig;
>>>>>>> parent of d40d236... no message:app/src/main/java/com/charles/common/view/BaseActivity.java

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * com.charles.common.view.BaseActivity
 *
 * @author Just.T
 * @since 16/12/26
 */
public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements IBaseView {

    private final String TAG = getClass().getSimpleName();
    protected BaseActivity mActivity;
    protected P mPresenter;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        initPresenter();
        setContentView(getContetView());
        init();
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

    protected abstract void init();

    protected abstract int getContetView();

<<<<<<< HEAD:mvplibary/src/main/java/com/charles/common/view/BaseActivity.java
    public void log(String log) {
        Log.d(TAG, log);
=======
    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
>>>>>>> parent of d40d236... no message:app/src/main/java/com/charles/common/view/BaseActivity.java
    }

}
