package com.example.http_mvp_frame.ui.tongpao.home;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.http_mvp_frame.R;
import com.example.http_mvp_frame.base.BaseActivity;
import com.example.http_mvp_frame.interfaces.interfaces.tongpao.IHomeContract;
import com.example.http_mvp_frame.module.data.person.PersonDataBean;
import com.example.http_mvp_frame.module.data.tongpaohome.BannerBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Hot_UserBean;
import com.example.http_mvp_frame.module.data.tongpaohome.RecommendBean;
import com.example.http_mvp_frame.module.data.tongpaohome.Topic_DiscussedBean;
import com.example.http_mvp_frame.persenter.tongpao.RecommendPersenter;
import com.example.http_mvp_frame.ui.tongpao.home.adapter.person.PersonAdapter;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.PersonalActivityFragment;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.PersonalArticleFragment;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.PersonalDataFragment;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.PersonalDynamicFragment;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.PersonalMassFragment;
import com.example.http_mvp_frame.ui.tongpao.home.personalfagemnt.personadapter.PerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PersonActivity extends BaseActivity<RecommendPersenter> implements IHomeContract.View {

    private TabLayout tab_personal;
    private ViewPager vp_person;
    private ArrayList<Fragment> fragments;
    private RecyclerView rcy_person;

    private ArrayList<PersonDataBean.DataBean>person_list;
    private PersonAdapter personAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_person;
    }

    @Override
    protected void inintView() {
        tab_personal = (TabLayout) findViewById(R.id.tab_personal);
        vp_person = (ViewPager) findViewById(R.id.vp_person);
        rcy_person = (RecyclerView) findViewById(R.id.rcy_person);
        rcy_person.setLayoutManager(new LinearLayoutManager(this));
        person_list=new ArrayList<>();
        personAdapter =new PersonAdapter(this,person_list);
        rcy_person.setAdapter(personAdapter);
        inintFagment();
    }

    @Override
    protected RecommendPersenter cretePersenter() {
        return new RecommendPersenter(this);
    }

    @Override
    protected void inintData() {

        persenter.getPersonal();
    }
    private void inintFagment() {
        fragments = new ArrayList<>();
        fragments.add(new PersonalDataFragment());
        fragments.add(new PersonalActivityFragment());
        fragments.add(new PersonalArticleFragment());
        fragments.add(new PersonalDynamicFragment());
        fragments.add(new PersonalMassFragment());
        PerAdapter perAdapter = new PerAdapter(getSupportFragmentManager(), fragments);
        vp_person.setAdapter(perAdapter);
        tab_personal.setupWithViewPager(vp_person);
        tab_personal.getTabAt(0).setText("资料");
        tab_personal.getTabAt(1).setText("动态");
        tab_personal.getTabAt(2).setText("活动");
        tab_personal.getTabAt(3).setText("社团");
        tab_personal.getTabAt(4).setText("文章");

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
        person_list.clear();
        person_list.add(personDataBean.getData());
        personAdapter.notifyDataSetChanged();
    }
}