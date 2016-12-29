package com.charles.common.network;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Just.T on 16/12/9.
 */

public interface BaseHttpService {

    @GET
    Observable<ResponseBody> downloadFile(@Url String url);

}
