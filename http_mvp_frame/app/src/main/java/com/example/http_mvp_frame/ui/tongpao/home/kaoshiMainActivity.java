package com.example.http_mvp_frame.ui.tongpao.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseActivity;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.persenter.tongpao.RecommendPersenter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.FragmentAdapter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.RemanAdapter;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.BlankFragment1;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.BlankFragment2;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.BlankFragment3;
import com.example.http_mvp_frame.ui.tongpao.home.fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class kaoshiMainActivity extends BaseActivity<RecommendPersenter> implements IHomeContract.View {

    private RecyclerView rcyks;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    List<Topic_DiscussedBean.DataBean> discussedList;
    private RemanAdapter remanAdapter;
    private TabLayout tabkaoshi;
    private ViewPager chaoshivp;
    private ArrayList<Fragment> fragments;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void inintView() {
        discussedList = new ArrayList<>();
        rcyks = (RecyclerView) findViewById(R.id.rcyks);
        tabkaoshi = (TabLayout) findViewById(R.id.tabkaoshi);
        chaoshivp = (ViewPager) findViewById(R.id.chaoshivp);

        rcyks.setLayoutManager(new LinearLayoutManager(this));
        remanAdapter = new RemanAdapter(this, discussedList);
        rcyks.setAdapter(remanAdapter);

        inintFagement();
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        Glide.with(this).load(R.drawable.a).into(iv1);
        Glide.with(this).load(R.drawable.b).into(iv2);
        Glide.with(this).load(R.drawable.c).into(iv3);
    }

    private void inintFagement() {
        fragments = new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        chaoshivp.setAdapter(fragmentAdapter);
        tabkaoshi.setupWithViewPager(chaoshivp);
        tabkaoshi.getTabAt(0).setText("热点");
        tabkaoshi.getTabAt(1).setText("装造");
        tabkaoshi.getTabAt(2).setText("图赞");
        tabkaoshi.getTabAt(3).setText("百科");
    }

    @Override
    protected RecommendPersenter cretePersenter() {
        return new RecommendPersenter(this);
    }

    @Override
    protected void inintData() {
        persenter.getTopic_Discussed();
    }

    @Override
    public void getBanner(BannerBean bannerBean) {

    }

    @Override
    public void getTopic_Discussed(Topic_DiscussedBean topic_discussedBean) {
        discussedList.addAll(topic_discussedBean.getData());
        remanAdapter.notifyDataSetChanged();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}