package com.charles.common.factory;

import com.charles.common.network.ProgressInterceptor;
import com.charles.common.network.ProgressListener;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * com.charles.common.factory.HttpClient
 *
 * @author Just.T
 * @since 16/12/28
 */
public class HttpClientFactory {

    private static final int DEFAUT_CONNECT_TIMEOUT = 10;
    private static final int DEFAUT_READ_TIMEOUT = 10;
    private static final OkHttpClient.Builder builder;

    static {
        builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAUT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAUT_READ_TIMEOUT, TimeUnit.SECONDS);
    }

    public static OkHttpClient defaultClient() {
        return builder.build();
    }

    public static OkHttpClient downloadClient(ProgressListener listener) {
        builder.networkInterceptors().add(new ProgressInterceptor(listener));
        return builder.build();
    }


}
