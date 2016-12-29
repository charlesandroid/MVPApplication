package com.charles.myapplication.main;

import com.charles.common.network.BaseHttpService;
import com.charles.common.network.DefaultData;
import com.charles.common.network.Response;
import com.charles.myapplication.main.bean.User;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * com.charles.myapplication.main.MainService
 *
 * @author Just.T
 * @since 16/12/29
 */
public interface MainService extends BaseHttpService {
    @GET("evaluate/house/query/")
    Observable<Response<DefaultData<User>>> getMessage(@Query("appNo") String appNo);
}
