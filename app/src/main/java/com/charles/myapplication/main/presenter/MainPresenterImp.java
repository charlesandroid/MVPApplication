package com.charles.myapplication.main.presenter;

import com.charles.common.network.RetrofitUtil;
import com.charles.common.network.TransformUtils;
import com.charles.common.presenter.BasePresenterImp;
import com.charles.common.view.BaseActivity;
import com.charles.myapplication.main.IMainView;
import com.charles.myapplication.main.MainPresenter;
import com.charles.myapplication.main.MainService;
import com.charles.myapplication.main.bean.User;
import com.charles.myapplication.network.DefaultData;
import com.charles.myapplication.network.Response;
import com.charles.myapplication.network.ResponseSubscriber;

/**
 * com.charles.myapplication.main.presenter.MainPresenterImp
 *
 * @author Just.T
 * @since 16/12/27
 */
public class MainPresenterImp extends BasePresenterImp<IMainView> implements MainPresenter {


    public MainPresenterImp(BaseActivity activity, IMainView view) {
        super(activity, view);
    }

    @Override
    public void initData() {
        MainService httpService = RetrofitUtil.getInstance().createService(MainService.class);
        httpService.getMessage("MH201610131600002603")
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new ResponseSubscriber<DefaultData<User>>() {
                    @Override
                    public void success(DefaultData<User> t) {
                        view.setText(t.response.address);
                    }

                    @Override
                    public void fail(Response t) {

                    }

                });
    }
}
