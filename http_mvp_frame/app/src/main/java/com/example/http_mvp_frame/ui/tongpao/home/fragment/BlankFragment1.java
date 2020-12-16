package com.example.http_mvp_frame.ui.tongpao.home.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseFragment;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.kaoshiData;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.persenter.tongpao.RecommendPersenter;

import java.util.List;

import butterknife.BindView;

public class BlankFragment1 extends BaseFragment<RecommendPersenter> implements IHomeContract.View {


   // @BindView(R.id.rcy_rd)
   // private RecyclerView rcy_rd;

    @Override
    public int getLayout() {
        return R.layout.fragment_blank1;
    }

    @Override
    public void inintView() {
     //   rcy_rd.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public RecommendPersenter createPersenter() {
        return null;
    }

    @Override
    public void inintData() {

    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getTopic_Discussed(Topic_DiscussedBean topic_discussedBean) {

    }

    @Override
    public void getRecommendReturn(RecommendBean result) {

    }

    @Override
    public void getHot_User(Hot_UserBean hot_userBean) {

    }

    @Override
    public void getPersonal(PersonDataBean personDataBean) {

    }

    @Override
    public void showToast(String msg, int time) {

    }
}