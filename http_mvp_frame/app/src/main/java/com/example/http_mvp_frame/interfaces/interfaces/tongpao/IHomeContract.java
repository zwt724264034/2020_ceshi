package com.example.http_mvp_frame.interfaces.interfaces.tongpao;

import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.IBasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;
import com.example.http_mvp_frame.interfaces.interfaces.IModel;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;

/**
 * 同袍首页推荐功能接口契约类
 */
public interface IHomeContract {

    //定义被推荐页实现View层接口方法
    interface View extends IBaseView {

        //首页推荐banner轮播图
        void getBanner(BannerBean bannerBean);

        // 首页推荐热门话题
        void getTopic_Discussed(Topic_DiscussedBean topic_discussedBean);

        //首页推荐数据
        void getRecommendReturn(RecommendBean result);

        //首页推荐热门用户
        void getHot_User(Hot_UserBean hot_userBean);

        //个人信息
        void getPersonal(PersonDataBean personDataBean);
    }

    //定义首页推荐页面V层调用的接口
    interface Persenter extends IBasePersenter<View> {

        void getBanner();

        void getTopic_Discussed();

        void getRecommend();

        void getHot_User();

        void getPersonal();


    }

    //定义加载推荐数据的接口方法 被P层调用
    interface Model extends IModel {
        void loadBanner(Callback callback);

        void loadTopic_Discussed(Callback callback);

        void loadRecommend(Callback callback);

        void loadHot_User(Callback callback);

        void loadPersonalr(Callback callback);

    }
}
