package com.example.http_mvp_frame.module.tongpaomodel;

import com.example.http_mvp_frame.base.BaseModel;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.net.CommonSubscriber;
import com.example.http_mvp_frame.net.HttpManager;
import com.example.http_mvp_frame.utils.RxUtils;

public class RecommendModel extends BaseModel implements IHomeContract.Model{
    @Override
    public void loadBanner(Callback callback) {
        addDisposable(
                HttpManager.getInstance().gettongpaoService().getBanner()
                .compose(RxUtils.<BannerBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<BannerBean>(callback) {
                            @Override
                            public void onNext(BannerBean bannerBean) {
                                callback.success(bannerBean);
                            }
                        })
        );
    }

    @Override
    public void loadTopic_Discussed(Callback callback) {
        addDisposable(
                HttpManager.getInstance().gettongpaoService().getTopic_Discussed()
                        .compose(RxUtils.<Topic_DiscussedBean>rxScheduler())
                        .subscribeWith(new CommonSubscriber<Topic_DiscussedBean>(callback) {
                            @Override
                            public void onNext(Topic_DiscussedBean topic_discussedBean) {
                                callback.success(topic_discussedBean);
                            }
                        })
        );
    }

    @Override
    public void loadRecommend(final Callback callback) {
        addDisposable(
                HttpManager.getInstance().gettongpaoService().getRecommend()
                .compose(RxUtils.<RecommendBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RecommendBean>(callback) {
                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        callback.success(recommendBean);
                    }
                })
        );
    }

    @Override
    public void loadHot_User(Callback callback) {
        addDisposable(
                HttpManager.getInstance().gettongpaoService().getHot_User()
                .compose(RxUtils.<Hot_UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<Hot_UserBean>(callback) {
                    @Override
                    public void onNext(Hot_UserBean hot_userBean) {
                        callback.success(hot_userBean);
                    }
                })
        );
    }

    @Override
    public void loadPersonalr(Callback callback) {
        addDisposable(
                HttpManager.getInstance().gettongpaoService().getPersonal()
                .compose(RxUtils.<PersonDataBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<PersonDataBean>(callback) {
                    @Override
                    public void onNext(PersonDataBean personDataBean) {
                        callback.success(personDataBean);
                    }
                })
        );
    }

    @Override
    public void clear() {

    }
}
