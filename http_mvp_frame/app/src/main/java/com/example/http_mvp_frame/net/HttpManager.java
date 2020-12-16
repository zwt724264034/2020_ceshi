package com.example.http_mvp_frame.net;

import com.example.http_mvp_frame.api.HttpApi;
import com.example.http_mvp_frame.api.ImageApi;
import com.example.http_mvp_frame.api.ShopApi;
import com.example.http_mvp_frame.api.Tongpao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求
 * 整个项目全局使用
 */
public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null) {
            if (instance == null) {
                instance = new HttpManager();
            }
        }
        return instance;
    }
    private ShopApi shopApi;

    //retrofit请求对象的对象池
    private Map<String,Retrofit> map = new HashMap<>();

    //局域网接口请求测试
    private HttpApi httpApi;

    //图片下载接口
    private ImageApi imageApi;
    //同袍
    private Tongpao tongpaoApi;

    public Retrofit getRetrofit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new HeaderInterceptor())
                .build();
        return okHttpClient;
    }

    static class LoggingInterceptor implements Interceptor {

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            return chain.proceed(request);
        }
    }

    static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Authorization", "APPCODE 964e16aa1ae944e9828e87b8b9fbd30a")
                    .build();
            return chain.proceed(request);
        }
    }

    /**
     * 同袍
     * @return
     */
    public Tongpao gettongpaoService() {
        if (tongpaoApi == null) {
            tongpaoApi = getRetrofit(Tongpao.BASE_URL).create(Tongpao.class);
        }
        return tongpaoApi;
    }
    /**
     * ShopApi
     * @return
     */
    public ShopApi getShopapi(){
        if(shopApi == null){
            shopApi = getRetrofit(ShopApi.SHOP_URL).create(ShopApi.class);
        }
        return shopApi;
    }
    /**
     * HttpApi
     * @return
     */
    public HttpApi getHttpApi(){
        if(httpApi ==  null){
            httpApi = getRetrofit(HttpApi.BASE_URL).create(HttpApi.class);
        }
        return httpApi;
    }
    /**
     * 获取图片下载的对象
     * @param baseUrl
     * @return
     */
    public ImageApi getImageApi(String baseUrl){
        Retrofit retrofit = map.get(baseUrl);
        if(retrofit != null){
            imageApi = retrofit.create(ImageApi.class);
        }else{
            retrofit = getRetrofit(baseUrl);
            imageApi = retrofit.create(ImageApi.class);
            map.put(baseUrl,retrofit);
        }
        return imageApi;
    }

}

