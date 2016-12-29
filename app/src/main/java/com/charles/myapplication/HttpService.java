package com.charles.myapplication;

import com.charles.common.network.DefaultData;
import com.charles.common.network.Response;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Just.T on 16/12/9.
 */

public interface HttpService {
    @GET("evaluate/house/query/")
    Observable<Response<DefaultData<Bean>>> getMessage(@Query("appNo") String appNo);

    @GET
    Observable<ResponseBody> downloadFile(@Url String url);

}
