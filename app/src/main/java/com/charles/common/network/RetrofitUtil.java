package com.charles.common.network;

import com.charles.common.factory.HttpClientFactory;
import com.charles.myapplication.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.charles.common.network.RetrofitUtil
 * <p>
 * 网络请求工具类
 *
 * @author Just.T
 * @since 16/12/26
 */
public class RetrofitUtil {
    private static final Gson gsonDateFormat;
    private static final Retrofit.Builder builder;

    static {

        gsonDateFormat = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        builder = new Retrofit
                .Builder();
    }

    private RetrofitUtil() {
    }

    private static class Holder {
        private static final RetrofitUtil retrofit = new RetrofitUtil();
    }

    public static RetrofitUtil getInstance() {
        return Holder.retrofit;
    }


    public <T> T createService(Class<T> cls) {
        return createService(HttpClientFactory.defaultClient(), cls);
    }

    public <T> T createService(OkHttpClient client, Class<T> cls) {
        Retrofit retrofit = builder
                .client(client)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonDateFormat))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(cls);

    }

}
