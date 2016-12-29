package com.charles.common.network;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * com.charles.common.network.HttpService
 *
 * @author Just.T
 * @since 16/12/28
 */
public interface HttpService {

    @GET
    Observable<ResponseBody> downloadFile(@Url String url);

}
