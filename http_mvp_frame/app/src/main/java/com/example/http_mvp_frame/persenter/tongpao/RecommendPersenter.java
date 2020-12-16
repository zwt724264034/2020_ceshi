package com.example.http_mvp_frame.persenter.tongpao;

import com.example.http_mvp_frame.base.BasePersenter;
import com.example.http_mvp_frame.interfaces.interfaces.Callback;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.module.tongpaomodel.RecommendModel;

public class RecommendPersenter extends BasePersenter<IHomeContract.View> implements IHomeContract.Persenter {
    IHomeContract.View view;
    IHomeContract.Model model;

    public RecommendPersenter(IHomeContract.View view) {
        this.view = view;
        this.model = new RecommendModel();
    }

    @Override
    public void getBanner() {
        this.model.loadBanner(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getBanner((BannerBean) o);
                }
            }
        });
    }

    @Override
    public void getTopic_Discussed() {
        this.model.loadTopic_Discussed(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getTopic_Discussed((Topic_DiscussedBean) o);
                }
            }
        });
    }

    @Override
    public void getRecommend() {
        this.model.loadRecommend(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getRecommendReturn((RecommendBean) o);
                }
            }
        });
    }

    @Override
    public void getHot_User() {
        this.model.loadHot_User(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getHot_User((Hot_UserBean) o);
                }
            }
        });
    }

    @Override
    public void getPersonal() {
        this.model.loadPersonalr(new Callback() {
            @Override
            public void fail(String msg) {
                if (view != null) {
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view != null) {
                    view.getPersonal((PersonDataBean) o);
                }
            }
        });
    }
}
