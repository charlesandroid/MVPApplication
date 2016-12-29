package com.charles.common.view;

import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.charles.common.presenter.BasePresenter;
import com.charles.myapplication.BuildConfig;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * com.charles.common.view.BaseActivity
 *
 * @author Just.T
 * @since 16/12/26
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private final String TAG = getClass().getSimpleName();
    protected Application mApplication;
    protected BaseActivity mActivity;
    protected P mPresenter;
    protected Toast mToast;
    private Unbinder mUnbind;

    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mApplication = getApplication();
        initPresenter();
        setContentView(getContetView());
        mUnbind = ButterKnife.bind(this);
        initView();
        initData();
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

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getContetView();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }


    public void hideDialog(Dialog dialog) {
        if (mPresenter.checkActivityState() && dialog != null && dialog.isShowing()) {
            if (mPresenter.isMainThread()) {
                dialog.dismiss();
            } else {
                runOnUiThread(dialog::dismiss);
            }
        }

    }

    public void showDialog(Dialog dialog) {
        if (mPresenter.checkActivityState() && dialog != null && !dialog.isShowing()) {
            if (mPresenter.isMainThread()) {
                dialog.show();
            } else {
                runOnUiThread(dialog::show);
            }
        }
    }

    public void showToast(String str) {
        if (!TextUtils.isEmpty(str) && mPresenter.checkActivityState()) {
            if (mPresenter.isMainThread()) {
                showToastSafe(str);
            } else {
                runOnUiThread(() -> showToastSafe(str));
            }
        }
    }

    private void showToastSafe(String str) {
        if (mToast == null) {
            mToast = Toast.makeText(this, str, Toast.LENGTH_SHORT);
        } else {
            mToast.cancel();
            mToast.setText(str);
        }
        mToast.show();

    }

    protected void log(String log) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, log);
        }
    }

}
