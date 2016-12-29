package com.charles.myapplication;

import com.charles.common.network.DefaultData;
import com.charles.common.network.Response;
import com.charles.common.network.ResponseSubscriber;
import com.charles.common.network.RetrofitUtil;
import com.charles.common.network.TransformUtils;
import com.charles.common.presenter.BasePresenterImp;
import com.charles.common.view.BaseActivity;
import com.charles.myapplication.Bean;
import com.charles.myapplication.HttpService;
import com.charles.myapplication.IMainView;
import com.charles.myapplication.MainPresenter;

/**
 * com.charles.myapplication.MainPresenterImp
 *
 * @author Just.T
 * @since 16/12/27
 */
public class MainPresenterImp extends BasePresenterImp<IMainView> implements MainPresenter {


    public MainPresenterImp(BaseActivity activity, IMainView view) {
        super(activity, view);
    }

    public void testRetrofit() {


        HttpService httpService = RetrofitUtil.getInstance().createService(HttpService.class);
        httpService.getMessage("MH201610131600002603")
                .compose(TransformUtils.defaultSchedulers())
                .subscribe(new ResponseSubscriber<DefaultData<Bean>>() {
                    @Override
                    public void success(DefaultData<Bean> t) {
                        view.setText(t.response.address);
                    }

                    @Override
                    public void fail(Response t) {

                    }

                });

    }

}
