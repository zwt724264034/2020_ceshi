package com.example.http_mvp_frame.api;


import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Tongpao {
    String BASE_URL = "http://cdwan.cn:7000/";

    //首页推荐轮播图接口：/home/banner.json
    @GET("tongpao//home/banner.json")
    Flowable<BannerBean> getBanner();

    // 首页推荐热门话题接口：/home/topic_discussed.json
    @GET("tongpao//home/topic_discussed.json")
    Flowable<Topic_DiscussedBean> getTopic_Discussed();

    //首页推荐数据接口
    @GET("tongpao/home/recommend.json")
    Flowable<RecommendBean> getRecommend();

    //首页推荐热门用户：/home/hot_user.json
    @GET("tongpao//home/hot_user.json")
    Flowable<Hot_UserBean> getHot_User();
    @GET("tongpao//home/personal.json")
    Flowable<PersonDataBean>getPersonal();


}
