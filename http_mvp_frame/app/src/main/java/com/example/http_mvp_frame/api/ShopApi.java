package com.example.http_mvp_frame.api;

import com.example.http_mvp_frame.module.data.shop.ShopBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {
    //https://cdplay.cn/api/index
    String SHOP_URL="https://cdplay.cn/";
    @GET("api/index")
    Flowable<ShopBean>getShop();
}
