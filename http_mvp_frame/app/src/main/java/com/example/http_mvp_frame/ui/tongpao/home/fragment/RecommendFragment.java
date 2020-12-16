package com.example.http_mvp_frame.ui.tongpao.home.fragment;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.DiscussedAdapter;
import com.example.http_mvp_frame.base.BaseAdapter;
import com.example.http_mvp_frame.base.BaseFragment;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.persenter.tongpao.RecommendPersenter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.Hot_UserAdapter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.RecommendAdapter;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class RecommendFragment extends BaseFragment<RecommendPersenter> implements IHomeContract.View {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerview_talk)
    RecyclerView recyclerviewTalk;
    @BindView(R.id.recyclerview_recommend)
    RecyclerView recyclerviewRecommend;
    @BindView(R.id.recyclerview_hotuser)
    RecyclerView recyclerviewHotuser;
    //热门话题
    DiscussedAdapter discussedAdapter;
    List<Topic_DiscussedBean.DataBean> discussedList;
    //推荐列表数据
    RecommendAdapter recommendAdapter;
    List<RecommendBean.DataBean> recommendList;
    //banner
    List<BannerBean.DataBean> bannerList = new ArrayList<>();
    //热门用户
    List<Hot_UserBean.DataBean> hot_userBeanList;
    Hot_UserAdapter hot_userAdapter;
    private ArrayList<Integer> banners;


    @Override
    public int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void inintView() {
        discussedList = new ArrayList<>();
        discussedAdapter = new DiscussedAdapter(getContext(), discussedList);
        recyclerviewTalk.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerviewTalk.setAdapter(discussedAdapter);
        discussedAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent();
                startActivity(intent);
            }
        });
        recommendList = new ArrayList<>();
        recommendAdapter = new RecommendAdapter(getContext(), recommendList);
        recyclerviewRecommend.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewRecommend.setAdapter(recommendAdapter);

        hot_userBeanList = new ArrayList<>();
        recyclerviewHotuser.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        hot_userAdapter = new Hot_UserAdapter(mContext, hot_userBeanList);
        recyclerviewHotuser.setAdapter(hot_userAdapter);
    }

    @Override
    public RecommendPersenter createPersenter() {
        return new RecommendPersenter(this);
    }

    @Override
    public void inintData() {
        persenter.getTopic_Discussed();
        persenter.getRecommend();
        persenter.getBanner();
        persenter.getHot_User();


    }

    //banner
    @Override
    public void getBanner(BannerBean bannerBean) {
        banners = new ArrayList<Integer>();
        banners.add(R.drawable.fhl);
        banners.add(R.drawable.xhhf);
        banners.add(R.drawable.hfcm);
        banners.add(R.drawable.hlwa);
        banners.add(R.drawable.tnhf);
        banners.add(R.drawable.hfrc);

        bannerList.clear();
        bannerList.add(bannerBean.getData());

//            recommendBannerAdapter.notifyDataSetChanged();
        banner.setImages(banners)
                .setBannerAnimation(Transformer.BackgroundToForeground)
                .setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
             //   BannerBean.DataBean.ListBean bean = (BannerBean.DataBean.ListBean) path;
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }

    @Override
    public void getTopic_Discussed(Topic_DiscussedBean topic_discussedBean) {
        discussedList.clear();
        discussedList.addAll(topic_discussedBean.getData());
        discussedAdapter.notifyDataSetChanged();
    }

    @Override
    public void getRecommendReturn(RecommendBean result) {
        recommendList.clear();
        recommendList.add(result.getData());
        recommendAdapter.notifyDataSetChanged();

    }

    @Override
    public void getHot_User(Hot_UserBean hot_userBean) {
        hot_userBeanList.clear();
        hot_userBeanList.addAll(hot_userBean.getData());
        hot_userAdapter.notifyDataSetChanged();
    }

    @Override
    public void getPersonal(PersonDataBean personDataBean) {

    }

    @Override
    public void showToast(String msg, int time) {

    }
}
