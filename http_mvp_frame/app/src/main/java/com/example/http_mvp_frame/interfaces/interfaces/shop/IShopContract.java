package com.example.http_mvp_frame.interfaces.interfaces.shop;

import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.IBasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.IBaseView;
import com.example.http_mvp_frame.interfaces.interfaces.IModel;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.shop.ShopBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;

public interface IShopContract {

    //定义被推荐页实现View层接口方法
    interface View extends IBaseView {

        void getShop(ShopBean shopBean);

    }

    //定义首页推荐页面V层调用的接口
    interface Persenter extends IBasePersenter<IShopContract.View> {

        void getShop();

    }

    //定义加载推荐数据的接口方法 呗P层调用
    interface Model extends IModel {
        void getShop(Callback callback);

    }
}
